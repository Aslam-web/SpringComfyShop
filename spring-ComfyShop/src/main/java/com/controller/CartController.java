package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.model.CartItem;
import com.model.Invoice;
import com.model.Product;
import com.service.CartItemService;
import com.service.InvoiceService;
import com.service.ProductService;
import com.service.UserService;

@Controller
@RequestMapping(value = { "/cart" })
public class CartController {

	@Autowired
	ProductService productService;

	@Autowired
	CartItemService cartItemService;

	@Autowired
	UserService userService;

	@Autowired
	InvoiceService invoiceService;

	@RequestMapping(value = { "/", "" })
	public String viewCart(ModelMap m, HttpSession session) {

		// validate user login
		if (!HelperController.validateUserLogin(m, session)) return "failure";

		// display cartItems
		return displayCartItems(session, m);
	}

	@RequestMapping(value = "/{productId}")
	public String addToCart(@PathVariable int productId, HttpSession session, ModelMap m) {

		// validate user login
		if (!HelperController.validateUserLogin(m, session)) return "failure";

		String username = session.getAttribute("username").toString();
		Product product = productService.getProduct(productId);
		cartItemService.addProductToCart(product, username);

		// display cartItems
		return displayCartItems(session, m);
	}

//	@RequestMapping(value = "/buy", method = RequestMethod.GET)
//	public String buyCart(HttpSession session, HttpServletRequest request, ModelMap m) {
//
//		// validate user login
//		if (!HelperController.validateUserLogin(m, session)) return "failure";
//
//		String username = session.getAttribute("username").toString();
//		// update payment status in cartitems and add invoice entry
//		List<CartItem> cartItems = cartItemService.initiatePaymentForOrder(username); // from NP to JP
//
//		// m-> user
//		m.addAttribute("user", userService.getUser(username));
//		// m-> cartItems
//		m.addAttribute("cartItems", cartItems);
//		
//		/** to be done in invoice (optionally)**/
//		Invoice invoice = invoiceService.completePaymentForOrder(username); // from JP to P and the invoice returned
//		// m-> invoice
//		m.addAttribute("invoice", invoice);
//		// m-> generatedInvoiceId
//		m.addAttribute("generatedInvoiceId", String.format("IN_%05d" , invoice.getInvoiceId()));
//		return "invoice";
//		
//		// then try
////		String baseUrl = ServletUriComponentsBuilder.fromRequestUri(request).replacePath(null).build().toString();
////		return "redirect:" + baseUrl + "/invoice";
//	}

	@RequestMapping(value = "/remove-{cartItemId}", method = RequestMethod.GET)
	public String removeCartItem(@PathVariable int cartItemId, HttpSession session, ModelMap m) {
		cartItemService.deleteCartItemsById(cartItemId);
		return displayCartItems(session, m);
	}

	@RequestMapping(value = "/remove-all", method = RequestMethod.GET)
	public String emptyCart(HttpSession session, ModelMap m) {
		cartItemService.emptyCart(session.getAttribute("username").toString());
		return displayCartItems(session, m);
	}
	
	private String displayCartItems(HttpSession session, ModelMap m) {
		List<CartItem> cartItems = cartItemService
				.getUserCartItemsByPaymentStatus(session.getAttribute("username").toString(), "NP");
		m.addAttribute("cartItems", cartItems);
		return "cart";
	}
}
