package com.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Invoice;

@Repository("invoiceDao")
public class InvoiceDAOImpl implements InvoiceDAO {

	@Autowired
	SessionFactory sf;

	private Session getSession() {
		return sf.getCurrentSession();
	}

	@Override
	public void addInvoice(Invoice invoice) {
		getSession().persist(invoice);
	}

	@Override
	public void updateInvoice(Invoice invoice) {
		Invoice entity = getSession().get(Invoice.class, invoice.getInvoiceId());
		if (entity != null) {
			entity.setOrderDate(invoice.getOrderDate());
			entity.setShippingAddr(invoice.getShippingAddr());
			entity.setTotalAmount(invoice.getTotalAmount());
			entity.setUsername(invoice.getUsername());
			getSession().persist(entity);
		} else {
			System.out.println("No such Invoice exists in database");
		}
	}

	@Override
	public void deleteInvoice(Invoice invoice) {
		getSession().delete(invoice);
	}

	@Override
	public void deleteInvoiceById(int invoiceId) {
		Invoice entity = getSession().get(Invoice.class, invoiceId);
		getSession().delete(entity);
	}

	@Override
	public Invoice getInvoiceById(int invoiceId) {
		Invoice entity = getSession().get(Invoice.class, invoiceId);
		if (entity != null) {
			return entity;
		} else {
			System.out.println("No such Invoice exists with id : " + invoiceId);
			return null;
		}
	}

	@Override
	public List<Invoice> getAllInvoices() {
		Criteria criteria = getSession().createCriteria(Invoice.class);
		return criteria.list();
	}
}