package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
//will be importing all annotations from this pkg
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "users_tbl") 
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"cart"})
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name = "user_id")
	private Integer id;
	
	@Length(min=4,max=20,message = "Invalid or Blank first name!!!!!!")
	@Column(name = "first_name", length = 20) 
	private String firstName;
	
	@Column(name = "last_name", length = 20) 
	@NotBlank(message = "Last  name can't be blank")
	private String lastName;
	
	@Column(length = 25, unique = true) 
	private String email;
	
	@Column(name="user_age")
	private int age;
	
	@Column(length = 20, nullable = false) 
	private String password;
	
	@Length(min=12,message = "please enter valid contact number")
	@Column(name="conact_No",nullable = false)
	private int contactNumber;
	
	@Enumerated(EnumType.STRING) 
	@Column(name = "user_role", length = 30)
	private Role userRole;
	
	@ReadOnlyProperty
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="DateOfBirth",nullable = false)
	private LocalDate DOB;
	
	
	// User(Customer) HAS-A Cart User 1---->1 Cart
	@OneToOne(mappedBy = "cartOwner", cascade = CascadeType.ALL, orphanRemoval = true)
	private ShoppingCart cart;
	
	@OneToOne
	@JoinColumn(name="user_address")
	private Address address;
	

	// helper method : to add cart
	public void addCart(ShoppingCart cart) {
		this.cart = cart;
		cart.setCartOwner(this);
	}

}
