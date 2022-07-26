package com.cg.book.app.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.book.app.exception.CategoryNotFoundException;
import com.cg.book.app.model.Category;
import com.cg.book.app.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
    public List<Category> getAllCategory() {
        List<Category> category = categoryRepository.findAll();
        if (category.isEmpty()) {
        	String exceptionMessage = "Category doesnt exist in database";
        	LOG.warn(exceptionMessage);
        	throw new CategoryNotFoundException(exceptionMessage);
        }else {
        	LOG.info("List returned Succesfully.");
        }
        return category;
    }
	
	@Override
	public Category getcategoryById(int id) {
		Category cat = categoryRepository.findCategoryByCategoryId(id);
		if (cat == null) {
			String exceptionMessage = "Category does not exist in the database.";
			LOG.warn(exceptionMessage);
			throw new CategoryNotFoundException(exceptionMessage);
		} else {
			LOG.info("List returned successfully.");
			return cat;
		}
	}

}
