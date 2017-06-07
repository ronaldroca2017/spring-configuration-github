package org.configuration.spring.web.dao;

import java.util.List;

import org.configuration.spring.web.model.Product;

public interface ProductoDao {
	List<Product> findAllProducts();
	List<Product> findAllFirstName(String firstName);
}
