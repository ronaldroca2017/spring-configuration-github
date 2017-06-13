package org.configuration.spring.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.configuration.spring.web.dao.ProductoDao;
import org.configuration.spring.web.model.Category;
import org.configuration.spring.web.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService {

	
	final static Logger logger = Logger.getLogger(ProductoServiceImpl.class);

	@Autowired
	ProductoDao productoDao;
	
	
	@Override
	public List<Product> findAllProducts() {
		logger.info("Service - findAllCategory ");
		return productoDao.findAllProducts();
	}

	@Override
	public List<Product> findAllFirstName(String firstName) {
		logger.info("Service - findAllFirstName - Parametro -> "  + firstName);
		return productoDao.findAllFirstName(firstName);
	}

	@Override
	public Integer saveProducto(Product product) {
		logger.info("Service - saveProducto(Product product) -> "  + product);
		return productoDao.saveProducto(product);
	}

	@Override
	public List<Category> getCategories() {
		logger.info("Service - getCategories()");
		return productoDao.getCategories();
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return productoDao.getProductById(id);
	}

	@Override
	public void deleteProducto(Product product) {
		productoDao.deleteProducto(product);
		
	}

}
