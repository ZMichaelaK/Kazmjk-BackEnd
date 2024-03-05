package com.lbg.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lbg.domain.Item;
import com.lbg.services.ItemServices;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class ItemController {

	private ItemServices service;

	public ItemController(ItemServices service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Item> createItem(@RequestBody Item newItem) {
		return this.service.createItem(newItem);
	}

	@GetMapping("/get")
	public List<Item> getItems() {
		return this.service.getItems();
	}

	@GetMapping("/get/{itemId}")
	public ResponseEntity<Item> getItem(@PathVariable Integer itemId) {
		return this.service.getItem(itemId);
	}

	@PatchMapping("/update/{itemId}")
	public ResponseEntity<Item> updateItem(@PathVariable Integer itemId, @RequestBody Item itemDetails) {
		return this.service.updateItem(itemId, itemDetails);
	}

	@DeleteMapping("/delete/{itemId}")
	public boolean deleteItem(@PathVariable Integer itemId) {
		return this.service.deleteItem(itemId);
	}

}
