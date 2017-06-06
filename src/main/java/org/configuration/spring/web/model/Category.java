package org.configuration.spring.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id_Category;
	private String name;

	
	

	
	

	
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
