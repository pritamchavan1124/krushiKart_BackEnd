
package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_details")
public class OrderDetails extends BaseEntity {

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Orders order;
	
//	@JsonIgnore
//	@ManyToMany
////	@JoinColumn(name = "product_id")
//	private List<Products> productlist=new ArrayList<Products>();
	

	// min order quantity 1
	private int quantity;

	private double unitPrice;

	// specified total or perticular product according to there quantity
	private double subtotal;

	private String productName;

	// to-string method

	@Override
	public String toString() {
		return "OrderItems [quantity=" + quantity + ", unitPrice=" + unitPrice + "]";
	}

}
