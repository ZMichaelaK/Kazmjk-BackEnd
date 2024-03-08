package com.lbg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.domain.Cart;
import com.lbg.repos.CartRepo;

@Service
public class CartServices {

	private CartRepo repo;

	public CartServices(CartRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Cart> createCart(Cart newCart) {
		Cart created = this.repo.save(newCart);
		return new ResponseEntity<Cart>(created, HttpStatus.CREATED);
	}

	public List<Cart> getCarts() {
		return this.repo.findAll();
	}

	public ResponseEntity<Cart> getCart(Integer id) {
		Optional<Cart> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}
		Cart body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Cart> updateCart(Integer id, Cart cartDetails) {
		Optional<Cart> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Cart>(HttpStatus.NOT_FOUND);
		}

		Cart existing = found.get();

		if (cartDetails.getItem() != null) {
			existing.setItem(cartDetails.getItem());
		}

		Cart updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean deleteCart(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
