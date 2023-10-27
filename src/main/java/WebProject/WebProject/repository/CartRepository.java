package WebProject.WebProject.repository;

import java.util.List;

import WebProject.WebProject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import WebProject.WebProject.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Long>{

//	@Query(value="DELETE FROM `cart` e WHERE e.id= ?1",nativeQuery = true)
//	void deleteById(int id);

	List<Cart> findAllByUser(User user);
	
}
