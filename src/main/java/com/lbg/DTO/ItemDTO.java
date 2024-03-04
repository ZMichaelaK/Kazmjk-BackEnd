package com.lbg.DTO;

import com.lbg.domain.Item;

public class ItemDTO {

	private Integer id;
	
	private String itemName;
	
	private String price;
	
	private Integer quantity;
	
	private Integer cartId;

	public ItemDTO(Item item) {
		super();
		this.setId(item.getId());
		this.setItemName(item.getItemName());
		this.setPrice(item.getPrice());
		this.setQuantity(item.getQuantity());
		if (item.getCart()!= null) {
			this.setCartId(item.getCart().getId());
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	
}

