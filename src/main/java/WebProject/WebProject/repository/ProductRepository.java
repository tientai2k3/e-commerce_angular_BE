package WebProject.WebProject.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import WebProject.WebProject.entity.Product;
/**
 * @author HOAN HAO
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{




}
