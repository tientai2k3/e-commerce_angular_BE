package WebProject.WebProject.service.impl;

import java.util.List;

import WebProject.WebProject.entity.User;
import WebProject.WebProject.model.request.CartRequest;
import WebProject.WebProject.repository.ProductRepository;
import WebProject.WebProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebProject.WebProject.entity.Cart;
import WebProject.WebProject.repository.CartRepository;
import WebProject.WebProject.service.CartService;

@Service
public class CartServicempl implements CartService{

	@Autowired
	CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;
	/**
	 *
	 */
	@Override
	public void deleteById(Long id) {
		cartRepository.deleteById(id);
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public List<Cart> findAllByUser(User user) {
		return cartRepository.findAllByUser(user);
	}

	@Override
	public Cart update(Long id, Integer request) {
		Cart c = cartRepository.findById(id).get();
		c.setCount(request);
		return cartRepository.save(c);
	}


	@Override
	public Cart add(Long idProduct,CartRequest request) {
		Cart cart = new Cart();
		cart.setCount(request.getCount());
		cart.setProduct(productRepository.findById(idProduct).get());
		cart.setUser(userRepository.findById(request.getIdUser()).get());
		return cartRepository.save(cart);
	}

	@Override
	public Cart findById(Long id) {
		return cartRepository.findById(id).get();
	}
}
