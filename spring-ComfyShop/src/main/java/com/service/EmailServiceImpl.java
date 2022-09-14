package com.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model.Invoice;
import com.repository.UserDAO;

@Service("emailService")
@Transactional
public class EmailServiceImpl implements EmailService {

	Session session;
	Properties props;
	
	@Autowired
	UserDAO userDAO;

	@Override
	public boolean emailExist(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendEmail(Invoice invoice) {

		// load properties from email.properties file
		props = new Properties();
		try {
			props.load(new FileInputStream("email.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// connect with a session
		session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("EMAIL"), props.getProperty("PASSWORD"));
			}
		});

		// create and send message
		try {
			Transport.send(createEmailBody(invoice));
			System.out.printf("Email successfully sent to <%s> !!!", invoice.getUsername());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	private Message createEmailBody(Invoice invoice) {
		Message message = new MimeMessage(session);

		// get the details from invoice and
		// get the name of the user using UserDAO
		String customerName = userDAO.getUserByEmail(invoice.getUsername()).getName();
		
		try {
			message.setFrom(new InternetAddress(props.getProperty("EMAIL")));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(invoice.getUsername()));
			message.setSubject("Order successful - CompfyShop");
			
			message.setText(
					"Dear " + customerName + ","
					+ "\n\nThank you for placing an order at ComfyShop. Here is the order details for your reference."
					
					+ "\n\nInvoice ID: " + String.format("IN_%05d" , invoice.getInvoiceId())
					+ "\nBilled to: " + customerName
					+ "\nAddress: " + invoice.getShippingAddr()
					+ "\nOrder Time: " + invoice.getOrderDate()
					+ "\nPurchase Amount: $" + invoice.getTotalAmount()
					
					+ "\n\n\nThanks & Regards"
					+ "\nComfyShop"
					+ "\nEmail: comfy.shop.aslam@gmail.com"
					+ "\nPhone: +91 98765 4321");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return message;
	}
}
