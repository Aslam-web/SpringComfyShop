package com.controller;

import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.model.User;
import com.service.UserService;

@Controller
@RequestMapping(value = { "/", "/user" })
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public String showLogin(ModelMap m) {
		// add the domain url as an attribute to session
		// log out of the user that was previously logged in

		User user = new User();
		m.addAttribute("user", user);
		return "user/login";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public String processLogin(User user, BindingResult result, HttpSession session, HttpServletRequest request,
			ModelMap m) {

//		if(result.hasErrors()) {
//			System.out.println("has errors");
//			return "login";
//		}

		if (session.getAttribute("username") != null && !session.getAttribute("username").equals("")) {
			userService.logoutUser(session.getAttribute("username").toString());
		}

		String email = user.getEmail();

		// check if user exist
		if (userService.checkUserByEmail(email)) {

			// get the user
			User entity = userService.getUser(email);

			// check password
			String password = user.getPassword();
			if (entity.getPassword().equals(password)) {
				userService.loginUser(email, password);

				{
					/*
					 * Global attributes once you logged in
					 */
					session.setAttribute("loggedIn", true);
					session.setAttribute("username", email);
					session.setAttribute("email", email);
				}

				String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).build()
						.toString();
				return "redirect:" + baseUrl + "/product/list";
			} else {
				m.addAttribute("error_info", "password for : " + email + " is incorrect !!!");
				System.out.println("Password incorrect");
				return "failure";
			}
		} else {
			m.addAttribute("error_info", "User with email : " + email + " not found !!!");
			System.out.println("User doesn't exist");
			return "failure";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegistration(ModelMap m) {
		User user = new User();
		m.addAttribute("user", user);
		return "user/registration";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(User user, BindingResult result, HttpSession session, HttpServletRequest request,
			ModelMap m) {

		User entity = userService.getUser(user.getEmail());
		if (entity != null) {
			m.addAttribute("error_info",
					"User with email : " + user.getEmail() + " already exist. Try logging in instead!!!");
			System.out.println("User already exist. They may login instead");
			return "failure";
		}
		user.setActive(true);
		user.setRole("ROLE_USER");
		userService.addUser(user);
		session.setAttribute("username", user.getEmail());
		session.setAttribute("email", user.getEmail());

		String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).build().toString();
		return "redirect:" + baseUrl + "/product/list";
	}

	@RequestMapping(value = "/logout")
	public String logoutUser(HttpSession session, ModelMap m) {
		Object username = session.getAttribute("username");
		System.out.println(username);
		if (username == null || username.equals("")) {
			System.out.println("You must be logged in first");
			m.addAttribute("error_info", "You must be logged in first!!!");
			return "failure";
		}
		userService.logoutUser(username.toString());

		{
			/*
			 * Global attributes once you log out
			 */
			session.removeAttribute("username");
			session.removeAttribute("email");
			session.setAttribute("loggedIn", false);
		}
		return "redirect:user/login";
	}
}