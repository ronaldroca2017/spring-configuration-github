package org.configuration.spring.web.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id_product;
	private String name;
	private String code;
	private BigDecimal price;
	private String description;
	private String active;
	private boolean checkBoxActive;
	
	@ManyToOne(fetch = FetchType.EAGER)//Traigo todos los productos y sus categorias
	@JoinColumn(name = "id_category", nullable = false)
	private Category category;
	
	public Integer getId_product() {
		return id_product;
	}
	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	
	
	
	public boolean isCheckBoxActive() {
		return checkBoxActive;
	}
	public void setCheckBoxActive(boolean checkBoxActive) {
		this.checkBoxActive = checkBoxActive;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "Product [id_product=" + id_product + ", name=" + name + ", code=" + code + ", price=" + price
				+ ", description=" + description + ", active=" + active + ", checkBoxActive=" + checkBoxActive
				+ ", category=" + category + "]";
	}
	
	
	
	
}
