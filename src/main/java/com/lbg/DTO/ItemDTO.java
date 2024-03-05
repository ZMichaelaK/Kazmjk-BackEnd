package com.lbg.DTO;

import com.lbg.domain.Item;

public class ItemDTO {

	private Integer itemId;

	private String itemName;

	private String price;

	private String quantity;

	private Integer cartId;

	public ItemDTO(Item item) {
		super();
		this.setItemId(item.getItemId());
		this.setItemName(item.getItemName());
		this.setPrice(item.getPrice());
		this.setQuantity(item.getQuantity());
		if (item.getCart() != null) {
			this.setCartId(item.getCart().getId());
		}
	}

	public ItemDTO() {
		super();
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
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

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

}
