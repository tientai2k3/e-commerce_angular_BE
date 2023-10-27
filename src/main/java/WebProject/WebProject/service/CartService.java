package WebProject.WebProject.service;

import java.util.List;

import WebProject.WebProject.entity.Cart;
import WebProject.WebProject.entity.User;
import WebProject.WebProject.model.request.CartRequest;

public interface CartService {
	
	void deleteById(Long id);

	List<Cart> findAll();
	
	List<Cart> findAllByUser(User user);

	Cart update(Long id,Integer cart);
	Cart add(Long idProduct,CartRequest request);
	Cart findById(Long id);
	
}
