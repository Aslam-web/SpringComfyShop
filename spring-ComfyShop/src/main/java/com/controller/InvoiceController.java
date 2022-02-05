package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Invoice;
import com.service.InvoiceService;

@Controller
//@RequestMapping(("/invoice"))
public class InvoiceController {
	
	@Autowired
	InvoiceService invoiceService;
	
	@RequestMapping(value = {"/",""})
	public String getInvoice(HttpSession session, ModelMap m) {
		System.out.println(m.getAttribute("user"));
		System.out.println(m.getAttribute("cartItems"));
		
//		// validate user login
//		if (!HelperController.validateUserLogin(m, session)) return "failure";
//		
//		Invoice invoice = invoiceService.completePaymentForOrder(session.getAttribute("username").toString()); // from JP to P and the invoice returned
//		// m-> invoice
//		m.addAttribute("invoice", invoice);
//		// m-> generatedInvoiceId
//		m.addAttribute("generatedInvoiceId", String.format("IN_%05d" , invoice.getInvoiceId()));
//		return "invoice";
		return "invoice";
	}
}