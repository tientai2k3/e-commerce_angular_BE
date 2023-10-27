package WebProject.WebProject.service;

import java.util.List;

import WebProject.WebProject.entity.Order;
import WebProject.WebProject.entity.Order_Item;

public interface Order_ItemService {

	List<Order_Item> findAllByOrder(Order order);
	void add(Order_Item order_item);
	void deleteById(Long id);
}
