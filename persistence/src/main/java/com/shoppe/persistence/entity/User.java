/**
 * 
 */
package com.shoppe.persistence.entity;

import javax.persistence.Entity;

/**
 * @author hungrymind
 *
 */
@SuppressWarnings("serial")
@Entity
public class User extends AbstractAuditableEntity{
	
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private Long contactNum;
	private String address;

	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the contactNum
	 */
	public Long getContactNum() {
		return contactNum;
	}

	/**
	 * @param contactNum the contactNum to set
	 */
	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

}
