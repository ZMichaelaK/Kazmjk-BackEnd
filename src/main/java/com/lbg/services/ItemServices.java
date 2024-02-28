package com.lbg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.domain.Item;
import com.lbg.repos.ItemRepo;

@Service
public class ItemServices {

	private ItemRepo repo;

	public ItemServices(ItemRepo repo) {
		super();
		this.repo = repo;
	}

	public ResponseEntity<Item> createItem(Item newItem) {
		Item created = this.repo.save(newItem);
		return new ResponseEntity<Item>(created, HttpStatus.CREATED);
	}

	public List<Item> getItems() {
		return this.repo.findAll();
	}

	public ResponseEntity<Item> getItem(int id) {
		Optional<Item> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}

		Item body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Item> updateItem(int id, Item itemDetails) {
		Optional<Item> found = this.repo.findById(id);

		if (found.isEmpty()) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}

		Item existing = found.get();

		if (itemDetails.getItemName() != null) {
			existing.setItemName(itemDetails.getItemName());
		}
		if (itemDetails.getItemDescription() != null) {
			existing.setItemDescription(itemDetails.getItemDescription());
		}
		if (itemDetails.getPrice() != null) {
			existing.setPrice(itemDetails.getPrice());
		}
		if (itemDetails.getQuantity() != null) {
			existing.setQuantity(itemDetails.getQuantity());
		}
		if (itemDetails.getImageUrl() != null) {
			existing.setImageUrl(itemDetails.getImageUrl());
		}
		if (itemDetails.getCart() != null) {
			existing.setCart(itemDetails.getCart());
		}

		Item updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean deleteItem(int id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}
