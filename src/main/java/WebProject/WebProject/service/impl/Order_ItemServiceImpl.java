package WebProject.WebProject.service.impl;

import java.util.List;

import WebProject.WebProject.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import WebProject.WebProject.entity.Order_Item;
import WebProject.WebProject.repository.Order_ItemRepository;
import WebProject.WebProject.service.Order_ItemService;

@Service
public class Order_ItemServiceImpl implements Order_ItemService{

	@Autowired
	Order_ItemRepository order_ItemRepository;

	@Override
	public List<Order_Item> findAllByOrder(Order order) {
		return order_ItemRepository.findAllByOrder(order);
	}

	@Override
	public void add(Order_Item order_item) {
		order_ItemRepository.save(order_item);
	}

	@Override
	public void deleteById(Long id) {
		order_ItemRepository.deleteById(id);
	}
}
