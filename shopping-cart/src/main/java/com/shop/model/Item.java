package com.shop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="items")
public class Item {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String itemName;
	private Double itemPrice;
	@Min(value = 0, message = "The value must be positive")
	private int itemQuantity;
	
	public Item() {
		
	}

	public Item(int id, String itemName, Double itemPrice, int itemQuantity) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	@Override
	public String toString() {
		return "Items [id=" + id + ", itemName=" + itemName + ", itemPrice=" + itemPrice + ", itemQuantity="
				+ itemQuantity + "]";
	}

}
