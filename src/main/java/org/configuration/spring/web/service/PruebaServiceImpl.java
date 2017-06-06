package org.configuration.spring.web.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.configuration.spring.web.dao.PruebaDao;
import org.configuration.spring.web.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruebaServiceImpl implements PruebaService {
	final static Logger logger = Logger.getLogger(PruebaServiceImpl.class);

	@Autowired
	PruebaDao pruebaDao;


	@Override
	public List<Category> findAllCategory() {
		logger.info("Service - findAllCategory ");
		return pruebaDao.findAllCategory();
	}

	@Override
	public List<Category> findFirstName(String name) {
		logger.info("Service - findFirstName(String name)  ");
		return pruebaDao.findFirstName(name);
	}
	
	
}
