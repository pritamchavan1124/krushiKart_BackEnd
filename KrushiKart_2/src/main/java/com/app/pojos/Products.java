package com.app.pojos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="prod_tbl")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Products extends BaseEntity{
	
	@Column(name="prod_Name",length = 100,nullable = false)
	private String prodName;
	
	@Column(name="prod_Desc",length = 200,nullable = false)
	private String prodDesc;
	
	@Column(name="prod_price",nullable = false)
	private double unitPrice;
	
	@Column(name="prod_Quantity",nullable = false)
	private int prodQuantity;
	
	@Column(length = 150)
	private String imageUrl;
	
	@Column(name="prod_weight")
	private double prodWeight;
	
	@Column(name="Special_Specification",length = 500)
	private String special_specification;
	
	@Column(name="manufacture_Date")
	private LocalDate mfgDate;
	
	//for category we use bi-directional trancation
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Category_cid")
	private Categorys prodCategory;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "orders_like", 
			  joinColumns = @JoinColumn(name = "product_id"), 
			  inverseJoinColumns = @JoinColumn(name = "orderDetails_id"))
	private List<OrderDetails> orderDetails=new ArrayList<OrderDetails>();


//	@JsonIgnore
//	@ManyToMany
//	@JoinTable(name="seller_prod_likes",
//					joinColumns=@JoinColumn(name="product_ids"),
//					inverseJoinColumns = @JoinColumn(name = "seller_id"))
//	private List<ProductSeller> sellerProdList=new ArrayList<ProductSeller>();
	
	//***************************************
	//hepler method for adding seed category
	public void addNewCategory(Categorys CatObj) {
		this.setProdCategory(CatObj);
		
	}
}