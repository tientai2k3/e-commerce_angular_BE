package WebProject.WebProject.service.impl;

import java.sql.Date;
import java.util.List;

import WebProject.WebProject.entity.Order;
import WebProject.WebProject.entity.User;
import WebProject.WebProject.model.request.OrderRequest;
import WebProject.WebProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import WebProject.WebProject.repository.OrderRepository;
import WebProject.WebProject.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;


	@Override
	public List<Order> findAllByUser(User user) {
		return orderRepository.findAllByUser(user);
	}

	@Override
	public Order findById(Long id) {
		return orderRepository.findById(id).get();
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Order add(OrderRequest request) {
		Order order = new Order();
		order.setBooking_Date(new Date(System.currentTimeMillis()));
		order.setStatus("create");
		order.setAddress(request.getAddress());
		order.setEmail(request.getEmail());
		order.setFullname(request.getFullname());
		order.setNote(request.getNote());
		order.setPayment_Method("Online");
		order.setUser(userRepository.findById(request.getIdUser()).get());
		order.setPhone(request.getPhone());
		order.setTotal(request.getTotal());
		return orderRepository.save(order);
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}
}
