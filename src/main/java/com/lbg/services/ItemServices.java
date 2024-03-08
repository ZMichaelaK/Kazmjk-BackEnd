package com.lbg.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.lbg.DTO.ItemDTO;
import com.lbg.domain.Cart;
import com.lbg.domain.Item;
import com.lbg.repos.CartRepo;
import com.lbg.repos.ItemRepo;

@Service
public class ItemServices {

	private ItemRepo repo;

	private CartRepo cartRepo;

	public ItemServices(ItemRepo repo, CartRepo cartRepo) {
		super();
		this.repo = repo;
		this.cartRepo = cartRepo;
	}

	public List<ItemDTO> getItem() {
		List<Item> items = this.repo.findAll();

		List<ItemDTO> dtos = new ArrayList<>();

		for (Item item : items) {
			ItemDTO dto = new ItemDTO();

			dto.setItemId(item.getItemId());
			dto.setItemName(item.getItemName());
			dto.setPrice(item.getPrice());
			dto.setQuantity(item.getQuantity());
			if (item.getCart() != null) {
				dto.setCartId(item.getCart().getId());
			}
			dtos.add(dto);

		}
		return dtos;

	}

	public ResponseEntity<Item> createItem(Item newItem) {
		Item created = this.repo.save(newItem);
		return new ResponseEntity<Item>(created, HttpStatus.CREATED);
	}

	public List<Item> getItems() {
		return this.repo.findAll();
	}

	public ResponseEntity<Item> getItem(Integer itemId) {
		Optional<Item> found = this.repo.findById(itemId);

		if (found.isEmpty()) {
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}

		Item body = found.get();

		return ResponseEntity.ok(body);
	}

	public ResponseEntity<Item> updateItem(Integer itemId, Item itemDetails) {
		Optional<Item> found = this.repo.findById(itemId);

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
			Optional<Cart> foundCart = this.cartRepo.findById(itemDetails.getCart().getId());
			existing.setCart(foundCart.get());
		}

		Item updated = this.repo.save(existing);

		return ResponseEntity.ok(updated);
	}

	public boolean deleteItem(Integer itemId) {
		this.repo.deleteById(itemId);
		return !this.repo.existsById(itemId);
	}

}
