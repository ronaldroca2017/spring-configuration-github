package org.configuration.spring.web.service;

import java.util.List;

import org.configuration.spring.web.model.Category;
import org.configuration.spring.web.model.Product;

public interface ProductoService {
	
	public abstract List<Product> findAllProducts();
	public abstract List<Product> findAllFirstName(String firstName);
	public abstract Integer saveProducto(Product product);
	public abstract List<Category> getCategories();
	
}
