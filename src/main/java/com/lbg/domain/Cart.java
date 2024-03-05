package com.lbg.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Boolean isInCart;

	@JsonManagedReference(value = "for-item")
	@OneToMany(mappedBy = "cart")
	private List<Item> item;

	public void setId(Integer id) {
		this.id = id;
	}

	public Cart() {
		super();

	}

	public Integer getId() {
		return id;
	}

	public List<Item> getItem() {
		return item;
	}

	public void setItem(List<Item> item) {
		this.item = item;
	}

	public Boolean getIsInCart() {
		return isInCart;
	}

	public void setIsInCart(Boolean isInCart) {
		this.isInCart = isInCart;
	}

}
