package WebProject.WebProject.service;

import java.util.List;

import WebProject.WebProject.entity.User;
import WebProject.WebProject.model.request.OrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import WebProject.WebProject.entity.Order;

public interface OrderService {

	List<Order> findAllByUser(User user);

	Order findById(Long id);

	List<Order> findAll();

	Order add(OrderRequest request);
	void deleteById(Long id);

}
