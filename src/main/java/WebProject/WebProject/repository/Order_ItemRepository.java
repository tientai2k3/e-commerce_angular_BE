package WebProject.WebProject.repository;

import java.util.List;

import WebProject.WebProject.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import WebProject.WebProject.entity.Order_Item;

public interface Order_ItemRepository extends JpaRepository<Order_Item,Long>{

	List<Order_Item> findAllByOrder(Order order);

	void deleteById(Long id);
	
}
