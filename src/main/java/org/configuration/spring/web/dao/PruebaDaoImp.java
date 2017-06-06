package org.configuration.spring.web.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.configuration.spring.web.model.Category;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PruebaDaoImp implements PruebaDao {
	final static Logger logger = Logger.getLogger(PruebaDaoImp.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	@SuppressWarnings("unchecked")
	public List<Category> findAllCategory() {
		logger.info("Busca todo las categorias de la bd");		
		return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Category> findFirstName(String name) {
		logger.info("Busca todo las categorias por nombre de la bd");
		return sessionFactory.getCurrentSession().createCriteria(Category.class)
		.add(Restrictions.like("firstName", name + "%").ignoreCase())
                .list();
	}

}
