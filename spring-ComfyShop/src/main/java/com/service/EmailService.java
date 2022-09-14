package com.service;

import com.model.Invoice;

public interface EmailService {
	boolean emailExist(String email);
	void sendEmail(Invoice invoice);
}