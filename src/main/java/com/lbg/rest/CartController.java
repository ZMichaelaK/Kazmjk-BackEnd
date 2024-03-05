package com.lbg.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.domain.Cart;
import com.lbg.services.CartServices;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

	private CartServices service;

	public CartController(CartServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Cart> createCart(@RequestBody Cart newCart) {
		return this.service.createCart(newCart);
	}

	@GetMapping("/get")
	public List<Cart> getCarts() {
		return this.service.getCarts();
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable Integer id) {
		return this.service.getCart(id);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Cart> updateCart(@PathVariable Integer id, @RequestBody Cart cartDetails) {
		return this.service.updateCart(id, cartDetails);
	}

	@DeleteMapping("/delete/{id}")
	public boolean deleteCart(@PathVariable Integer id) {
		return this.service.deleteCart(id);
	}
}
