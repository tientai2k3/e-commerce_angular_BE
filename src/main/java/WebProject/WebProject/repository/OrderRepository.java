package WebProject.WebProject.repository;

import java.util.List;
import java.util.Optional;

import WebProject.WebProject.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import WebProject.WebProject.entity.Order;
import WebProject.WebProject.entity.Product;

public interface OrderRepository extends JpaRepository<Order,Long>{
	List<Order> findAllByUser(User user);
	
}
