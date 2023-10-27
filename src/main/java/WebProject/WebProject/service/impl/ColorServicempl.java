package WebProject.WebProject.service.impl;

import WebProject.WebProject.entity.Cart;
import WebProject.WebProject.entity.Color;
import WebProject.WebProject.model.request.ColorRequest;
import WebProject.WebProject.repository.CartRepository;
import WebProject.WebProject.repository.ColorRepository;
import WebProject.WebProject.service.CartService;
import WebProject.WebProject.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServicempl implements ColorService {

	@Autowired
	ColorRepository repository;

	@Override
	public Color saveColor(ColorRequest request) {
		Color c = new Color();
		c.setColor_name(request.getColor_name());
		return repository.save(c);
	}

	@Override
	public Color updateColor(Long id, ColorRequest request) {
		Color c = repository.findById(id).get();
		c.setColor_name(request.getColor_name());
		return repository.save(c);
	}

	@Override
	public Color findById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Color> findAll() {
		return repository.findAll();
	}

	@Override
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
