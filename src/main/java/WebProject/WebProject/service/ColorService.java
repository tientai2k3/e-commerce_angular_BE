package WebProject.WebProject.service;

import WebProject.WebProject.entity.Category;
import WebProject.WebProject.entity.Color;
import WebProject.WebProject.model.request.ColorRequest;

import java.util.List;

public interface ColorService {
	
	Color saveColor(ColorRequest request);

	Color updateColor(Long id,ColorRequest request);

	Color findById(Long id);


	List<Color> findAll();

	void delete(Long id);
}
