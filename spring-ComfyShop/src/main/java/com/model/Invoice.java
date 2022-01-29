package com.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int invoiceId;

	int totalAmount;
	String username;
	Date orderDate;
	String shippingAddr;

	public Invoice(int invoiceId, int totalAmount, String username, Date orderDate, String shippingAddr) {
		this.invoiceId = invoiceId;
		this.totalAmount = totalAmount;
		this.username = username;
		this.orderDate = orderDate;
		this.shippingAddr = shippingAddr;
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddr() {
		return shippingAddr;
	}

	public void setShippingAddr(String shippingAddr) {
		this.shippingAddr = shippingAddr;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceId=" + invoiceId + ", totalAmount=" + totalAmount + ", username=" + username
				+ ", orderDate=" + orderDate + ", shippingAddr=" + shippingAddr + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoiceId, orderDate, shippingAddr, totalAmount, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		return invoiceId == other.invoiceId && Objects.equals(orderDate, other.orderDate)
				&& Objects.equals(shippingAddr, other.shippingAddr) && totalAmount == other.totalAmount
				&& Objects.equals(username, other.username);
	}
}