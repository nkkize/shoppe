package com.shoppe.persistence.entity;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Bill extends AbstractAuditableEntity{

	private Long quantity;
	private Long amount;
	private Long balance;
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public Long getBalance() {
		return balance;
	}
	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
}
