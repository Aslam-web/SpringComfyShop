package com.repository;

import java.util.List;

import com.model.Invoice;

public interface InvoiceDAO {

	void addInvoice(Invoice invoice);
	void updateInvoice(Invoice invoice);
	void deleteInvoice(Invoice invoice);
	void deleteInvoiceById(int invoiceId);
	
	Invoice getInvoiceById(int invoiceId);
	List<Invoice> getAllInvoices();
}