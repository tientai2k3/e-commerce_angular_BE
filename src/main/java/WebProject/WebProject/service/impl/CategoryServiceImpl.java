package WebProject.WebProject.service.impl;

import java.util.List;

import WebProject.WebProject.model.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import WebProject.WebProject.entity.Category;
import WebProject.WebProject.repository.CategoryRepository;
import WebProject.WebProject.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	 CategoryRepository categoryRepository;
	
	@Override
	public Category saveCategory(CategoryRequest request) {
		Category c = new Category();
		c.setCategory_Name(request.getCategory_Name());
		return categoryRepository.save(c);
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public Category updateCategory(Long id,CategoryRequest request) {
		Category c=categoryRepository.findById(id).get();
		c.setCategory_Name(request.getCategory_Name());

		return categoryRepository.save(c);
	}
	
	@Override
	public void deleteCategoryId(Long id) {
		categoryRepository.deleteById(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

}
