package com.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.dto.CartRequest;
import com.shop.dto.CartResponse;
import com.shop.exception.ItemNotFoundException;
import com.shop.service.CartServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1")
public class CartController {

	@Autowired
	CartServiceImpl cartServiceImpl;

	/**
	 * Adding list of Items in cart
	 * 
	 * @param req
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(value = "/cart/items", consumes = "application/json")
	public ResponseEntity<CartResponse> addItemToCart(@Valid @RequestBody CartRequest req,
			BindingResult bindingResult) {
		CartResponse response = new CartResponse();
		cartServiceImpl.addItemsToCart(req);
		response.setStatus(HttpStatus.CREATED.value());
		response.setMessage("Items added in cart");
		return ResponseEntity.status(response.getStatus()).body(response);
	}

	@GetMapping(value = "/cart/checkout")
	public ResponseEntity<String> getCheckoutAmount() {
		double amount = cartServiceImpl.getCheckoutAmount();
		return ResponseEntity.ok("Total Amount is : " + amount);
	}

	/**
	 * Deleting item in cart by Id Manual validation handling was working but
	 * implemented Global exception handler
	 * 
	 * @param id
	 * @return
	 * @throws ItemNotFoundException
	 */
	@DeleteMapping("/cart/items/{itemId}")
	public ResponseEntity<CartResponse> deleteItemFromCart(@PathVariable("itemId") int id)
			throws ItemNotFoundException {
		CartResponse response = new CartResponse();
		// try {
		cartServiceImpl.deleteItemFromCartById(id);
		response.setStatus(HttpStatus.OK.value());
		response.setMessage("Item with ID : " + id + " deleted from cart!");
//		} catch (ItemNotFoundException e) {
//			response.setStatus(HttpStatus.NOT_FOUND.value());
//			response.setMessage("Item with ID : " + id + " NOT FOUND!");
//		}
		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
