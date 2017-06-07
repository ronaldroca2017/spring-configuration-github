package org.configuration.spring.web.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.configuration.spring.web.model.Category;
import org.configuration.spring.web.model.Product;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class ProductoDaoImpl implements ProductoDao {

	
	final static Logger logger = Logger.getLogger(ProductoDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Product> findAllProducts() {
		logger.info("Busca todo las categorias de la bd");		
		return sessionFactory.getCurrentSession().createCriteria(Product.class).list();
	}

	@Override
	public List<Product> findAllFirstName(String firstName) {
		logger.info("Busca todo las categorias por nombre de la bd");
		return sessionFactory.getCurrentSession().createCriteria(Product.class)
		.add(Restrictions.like("name", firstName + "%").ignoreCase())
                .list();
	}

}
