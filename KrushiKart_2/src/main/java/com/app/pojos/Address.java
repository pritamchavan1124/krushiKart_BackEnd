package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Embeddable 
@Entity
@Table(name="address_tbl")
@Getter
@Setter
@ToString

public class Address extends BaseEntity{
	private int unit_number;
	@NotBlank
	private int street_number;
	@Column(length = 100)
	@NotBlank
	private String addressLine1;
	@Column(length = 100)
	private String addressLine2;
	@Column(length = 30)
	@NotBlank
	private String city;
	
	@Column(length = 30)
	@NotBlank
	private String state;
	
	@NotBlank
	private int postalCode;
	@Column(length = 30)
	@NotBlank
	private String country;
	
	public Address(int unit_number, @NotBlank int street_number, @NotBlank String addressLine1, String addressLine2,
			@NotBlank String city, @NotBlank String state, @NotBlank int postalCode, @NotBlank String country) {
		super();
		this.unit_number = unit_number;
		this.street_number = street_number;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
	}

	public Address() {
		super();
	}
	
	
//	@JoinColumn(name="order_id")
//	@OneToOne(cascade = CascadeType.ALL)
//	private Orders orders;
	
	
}
