package com.capgemini.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class ProductEntity extends AbstractEntity {

	@Column(nullable = false, length = 40)
    private String name;
	
	@Column(nullable = false, precision = 2, scale = 2)
    private double margin;
	
	@Column(nullable = false, length = 10)
    private double price;
	
	@OneToMany(mappedBy = "product")
	List<TransactionsDetailsEntity> transactionsDetails;

	public ProductEntity() {
		
	}

	public void setMargin(double margin) {
		this.margin = margin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMargin() {
		return margin;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

}
