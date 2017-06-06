package org.configuration.spring.web.service;

import java.util.List;

import org.configuration.spring.web.model.Category;

public interface PruebaService {
	List<Category> findAllCategory();
	List<Category> findFirstName(String name);
}
