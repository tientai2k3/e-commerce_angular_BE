package WebProject.WebProject.repository;

import WebProject.WebProject.entity.Category;
import WebProject.WebProject.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends JpaRepository<Color,Long> {
	
	Color getById(Long id);

}
