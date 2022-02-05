package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.CartItem;
import com.model.Invoice;
import com.repository.CartItemDAO;
import com.repository.InvoiceDAO;
import com.repository.UserDAO;

@Service("invoiceService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDAO invoiceDao;

	@Autowired
	CartItemDAO cartItemDao;

	@Autowired
	UserDAO userDao;

	@Override
	public void createInvoice(Invoice invoice) {
		invoiceDao.addInvoice(invoice);
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		invoiceDao.updateInvoice(invoice);
	}

	@Override
	public void deleteInvoice(Invoice invoice) {
		invoiceDao.deleteInvoice(invoice);
	}

	@Override
	public void deleteInvoiceById(int invoiceId) {
		invoiceDao.deleteInvoiceById(invoiceId);
	}

	@Override
	public Invoice getInvoiceById(int invoiceId) {
		return invoiceDao.getInvoiceById(invoiceId);
	}

//	@Override
//	public Invoice completePaymentForOrder(String username) {
//		List<CartItem> justPaidCartItems = cartItemDao.getUserCartItemsByPaymentStatus(username, "JP");
//		
//		// update from JUST_PAID to PAID for all CartItems
//		justPaidCartItems.forEach((i) -> {
//			cartItemDao.updateCartItemByPaymentStatus(i.getCartItemId(), "P");
//		});
//		
//		// create invoice and save it
//		Invoice invoice = new Invoice(generateTotalAmount(justPaidCartItems),
//				username, 
//				new Date(), 
//				userDao.getUserByEmail(username).getAddress());
//		invoiceDao.addInvoice(invoice);
//		
//		// return the invoice for front-end display
//		return invoice;
//	}
}