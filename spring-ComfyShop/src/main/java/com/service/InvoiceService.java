package com.service;

import com.model.Invoice;

public interface InvoiceService {

	void createInvoice(Invoice invoice);
	void updateInvoice(Invoice invoice);
	void deleteInvoice(Invoice invoice);
	void deleteInvoiceById(int invoiceId);
	
	Invoice getInvoiceById(int invoiceId);
	
//	Invoice completePaymentForOrder(String username);
}