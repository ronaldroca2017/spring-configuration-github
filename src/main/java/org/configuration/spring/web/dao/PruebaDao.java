package org.configuration.spring.web.dao;

import java.util.List;

import org.configuration.spring.web.model.Category;

public interface PruebaDao {

	List<Category> findAllCategory();
	List<Category> findFirstName(String name);
}
