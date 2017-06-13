package org.configuration.spring.web.dao;

import java.util.List;

import org.configuration.spring.web.model.Category;
import org.configuration.spring.web.model.Product;

public interface ProductoDao  {
	
	public abstract List<Product> findAllProducts();
	public abstract List<Product> findAllFirstName(String firstName);
	public abstract Integer saveProducto(Product product);
	public abstract List<Category> getCategories();
	public abstract Product getProductById(Integer id);
	public abstract void deleteProducto(Product product);
	
}
