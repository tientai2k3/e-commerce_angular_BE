package WebProject.WebProject.service;

import java.util.List;

import WebProject.WebProject.entity.Category;
import WebProject.WebProject.model.request.CategoryRequest;

public interface CategoryService {
	
	Category saveCategory(CategoryRequest request);

	Category findById(Long id);

	Category updateCategory(Long id,CategoryRequest request);
	
	List<Category> findAll();

	void deleteCategoryId(Long id);
}
