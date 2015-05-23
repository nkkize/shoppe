package com.shoppe.ws.action;

import org.springframework.stereotype.Component;

/**
 * @author NarenderK
 * 
 */
@Component
public class UserWS {

	private String userName;
	private String password;
	private Long contactNum;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return password;
	}

	public void setAddress(String address) {
		this.password = address;
	}

	public Long getContactNum() {
		return contactNum;
	}

	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}
}
