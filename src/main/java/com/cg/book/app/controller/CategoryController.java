package com.cg.book.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.book.app.model.Category;
import com.cg.book.app.service.CategoryService;

@RestController
@RequestMapping("/user")
// @CrossOrigin(origins = "*")

public class CategoryController {

	@Autowired
	CategoryService categoryService;

	// http://localhost:9999/user/get-all-Category
	@GetMapping("/getAllCategory")
	public List<Category> getAllCategory() {
		List<Category> allCategoryList = (List<Category>) categoryService.getAllCategory();
		return allCategoryList;
	}
//      @GetMapping("/get-category-by-name/{name}")
//      public ResponseEntity<Category> getCategoryByName(@PathVariable("name") String name) {
//          Category category = categoryService.getCategoryByName(name);
//          if (category == null) {
//              return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//          }
//          return ResponseEntity.of(Optional.of(category));
//      }

}