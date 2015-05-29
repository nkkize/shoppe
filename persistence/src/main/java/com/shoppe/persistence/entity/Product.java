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
public class Product extends AbstractAuditableEntity{
	
	private String productName;
	private String manufacturer;
	private Double pricePerUnit;
	private String description;
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}
	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	/**
	 * @return the pricePerUnit
	 */
	public Double getPricePerUnit() {
		return pricePerUnit;
	}
	/**
	 * @param pricePerUnit the pricePerUnit to set
	 */
	public void setPricePerUnit(Double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
