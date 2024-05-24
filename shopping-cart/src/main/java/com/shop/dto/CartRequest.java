package com.shop.dto;

import java.util.List;

import com.shop.model.Item;

import lombok.Data;

@Data
public class CartRequest {

	
	List<Item> itemsList;

	public CartRequest() {

	}

	public CartRequest(List<Item> itemsList) {
		super();
		this.itemsList = itemsList;
	}

	public List<Item> getIltemsList() {
		return itemsList;
	}

	public void setIltemsList(List<Item> iltemsList) {
		this.itemsList = iltemsList;
	}

}
