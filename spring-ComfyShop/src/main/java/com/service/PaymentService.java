package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.CartItem;
import com.model.Invoice;
import com.model.User;
import com.repository.CartItemDAO;
import com.repository.InvoiceDAO;
import com.repository.UserDAO;

@Service
@Transactional
public class PaymentService {
	
	@Autowired
	CartItemDAO cartItemDao;
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	InvoiceDAO invoiceDao;
	
	public Invoice doPayment(String username) {
		// make sure the cartItem is not empty
		//
		//
		//
		
		// build invoice and add to DB
		User user = userDao.getUserByEmail(username);
		Invoice invoice = new Invoice(getGrandTotalAmount(username), username, new Date(), user.getAddress());
		invoiceDao.addInvoice(invoice);
		
		// change payment status of all cartItems to payed(P)
		List<CartItem> notPaidCartItems = cartItemDao.getUserCartItemsByPaymentStatus(username, "NP");
		notPaidCartItems.forEach((i)->{
			i.setPaymentStatus("P");
		});
		
		return invoice;
	}
	
	public int getGrandTotalAmount(String username) {
		List<CartItem> notPaidCartItems = cartItemDao.getUserCartItemsByPaymentStatus(username, "NP");
		
		int total=0;
		for(CartItem i : notPaidCartItems) {
			total += i.getQuantity()*i.getPrice();
		}
		
		return total;
	}
}