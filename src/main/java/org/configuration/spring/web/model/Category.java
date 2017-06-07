package org.configuration.spring.web.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_Category;
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")//Solo traigo las categorias sin los productos
	private List<Product> products = new ArrayList<Product>();
	
	public Integer getId_Category() {
		return id_Category;
	}
	public void setId_Category(Integer id_Category) {
		this.id_Category = id_Category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
