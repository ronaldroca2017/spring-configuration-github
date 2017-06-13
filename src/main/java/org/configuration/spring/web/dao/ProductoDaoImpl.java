package org.configuration.spring.web.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.configuration.spring.web.model.Category;
import org.configuration.spring.web.model.Product;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ProductoDaoImpl implements ProductoDao{

	
	final static Logger logger = Logger.getLogger(ProductoDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Product> findAllProducts() {
		logger.info("Consulta todos los productos de la bd y los devuelve de forma descendente");	
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Product.class)
					.addOrder(Order.desc("id_product"));
		return c.list();
		
	}

	@Override
	public List<Product> findAllFirstName(String firstName) {
		logger.info("Consulta todos los productos por nombre de la bd");
		return sessionFactory.getCurrentSession().createCriteria(Product.class)
		.add(Restrictions.like("name", firstName + "%").ignoreCase())
                .list();
	}

	@Override
	public Integer saveProducto(Product product) {
		logger.info("Inserta producto en la bd");
		Integer id = (Integer) sessionFactory.getCurrentSession().save(product);
		if (id == 0) {
			logger.info("La insercción no se pudo realizar.");
			return 0;
		} else {
			logger.info("La insercción se realizó correctamente.");
			return 1;
		}
	}

	@Override
	public List<Category> getCategories() {
		logger.info("Consulta todas las categorias de la bd");		
		return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
		
	}

	@Override
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return (Product) sessionFactory.getCurrentSession().createCriteria(Product.class)
				.add(Restrictions.idEq(id)).uniqueResult();
	}

	@Override
	public void deleteProducto(Product product) {
		sessionFactory.getCurrentSession().delete(product);
		
	}
}
