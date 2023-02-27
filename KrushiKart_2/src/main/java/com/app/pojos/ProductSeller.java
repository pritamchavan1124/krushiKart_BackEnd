package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="seller_prod_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductSeller extends BaseEntity{
	
	@Column(name="prod_Name",length = 100,nullable = false)
	private String productName;
	
	@Column(name="prod_Desc",length = 100,nullable = false)
	private String productDesc;
	
	@Column(name="prod_Compamy_Name",length = 100,nullable = false)
	private String prodCompanyName;
	
	@Column(name="prod_Price",nullable = true)
	private double prodPrice;
	
	@Column(name="prod_Quantity",nullable = true)
	private int prodQuantity;
	
	@Column(name="prod_Image",nullable = true)
	private byte[] prodImage;
	
	@Column(name="other_prod_spec")
	private String prodSpecification;
	
//	@JsonIgnore
//	@ManyToMany
////	@JoinColumn(name="prod_id")
//	private List<Products> productList=new ArrayList<Products>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="seller_prod_list",
					joinColumns=@JoinColumn(name="product_id"),
					inverseJoinColumns = @JoinColumn(name = "seller_id"))
	private List<Products> productList=new ArrayList<>();
}
