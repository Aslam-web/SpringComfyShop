package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Product;
import com.service.ProductService;

@Controller
@RequestMapping(value = { "/product" })
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = { "", "/allproducts", "/list", "/all" }, method = RequestMethod.GET)
	public String listAllProducts(ModelMap m) {

		// load all products amd add to the modelmap
		return loadAllProducts(m, "product/allProducts");
	}

	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
	public String viewProduct(@PathVariable int productId, ModelMap m) {
		Product product = productService.getProduct(productId);
		m.addAttribute("product", product);
		m.addAttribute("condition", true);
		return "product/viewProduct";
	}

	@RequestMapping(value = "/manage", method = RequestMethod.GET)
	public String manageProducts(HttpSession session, ModelMap m) {
		// validate if the user is an admin. i.e. ROLE_ADMIN

		// validate user login
		if (!HelperController.validateUserLogin(m, session))
			return "failure";

		Product product = new Product();
		m.addAttribute("product", product);

		// load all products
		return loadAllProducts(m, "product/manageProducts");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addNewProduct(@ModelAttribute Product product, BindingResult result, ModelMap m) {
		int productId = productService.addProduct(product);
		System.out.println(productService.getProduct(productId));

		// load all products
		return loadAllProducts(m, "product/manageProducts");
	}

	@RequestMapping(value = "/delete-{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int productId, Product product, BindingResult result, ModelMap m) {
		
		if(result.hasErrors()) {
			m.addAttribute("error_info", result.getAllErrors().toString());
			return "failure";
		}
		
		productService.deleteProductById(productId);

		// load all products
		return loadAllProducts(m, "product/manageProducts");
	}

	private String loadAllProducts(ModelMap m, String path) {
		List<Product> products = productService.getAllProducts();
		m.addAttribute("products", products);

		return path;
	}
}
