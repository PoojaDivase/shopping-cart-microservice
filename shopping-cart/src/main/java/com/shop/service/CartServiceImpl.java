package com.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dto.CartRequest;
import com.shop.exception.ItemNotFoundException;
import com.shop.model.Item;

@Service
public class CartServiceImpl {

	@Autowired
	CartRepository cartRep;

	public void deleteItemFromCartById(int id) throws ItemNotFoundException {

		Optional<Item> op = Optional.ofNullable(cartRep.findById(id));
		System.out.println("optional : " + op);
		if (op.isPresent())
			cartRep.deleteById(id);
		else
			throw new ItemNotFoundException("Item with Id : " + id + " NOT FOUND!");

	}

	public void addItemsToCart(CartRequest cartRequest) {

		List<Item> itemsList = cartRequest.getIltemsList();
		for (int i = 0; i < itemsList.size(); i++) {
			cartRep.save(itemsList.get(i));
		}

	}

	public double getCheckoutAmount() {
		List<Item> allCartitems = cartRep.findAll();
		double totalAmount = allCartitems.stream().map(item -> item.getItemPrice()).mapToDouble(Double::doubleValue)
				.sum();
		return totalAmount;
	}

}
