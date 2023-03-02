package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cart_items")
//@NoArgsConstructor
//@Getter
//@Setter
//@ToString
public class CartItem extends BaseEntity {

	private Long quantity;
	@Column(name = "total_price")
	
	private double totalPrice;
	// Cart 1<---* CartItem
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cart_id", nullable = false)
	private ShoppingCart cart;
	// CartItem 1---->1 Product
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="Product_id")
	private Products product;
	
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private User user;
	
	@Transient
	public double getSubtotal() {
		return product.getUnitPrice() * quantity;
	}

	public CartItem(int quantity, double totalPrice, ShoppingCart cart, Products product, User user) {
		super();
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.cart = cart;
		this.product = product;
		this.user = user;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(Long updatedQuantity) {
		this.quantity = updatedQuantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CartItem() {
		super();
	}

	@Override
	public String toString() {
		return "CartItem [quantity=" + quantity + ", totalPrice=" + totalPrice + ", cart=" + cart + ", product="
				+ product + ", user=" + user + "]";
	}
	
}
