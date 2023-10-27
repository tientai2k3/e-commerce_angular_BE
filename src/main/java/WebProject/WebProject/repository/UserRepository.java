package WebProject.WebProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import WebProject.WebProject.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//	User findByEmail(String email);
//	@Query("select u from User u where u.userName=:username and u.password=:password")
//	User findUserByuserNameAnhPassword(@Param("username")String username,@Param("password")String password);

//	User findByIdAndRole(long id, String role);

	Optional<User> findByUserName(String username);

	Boolean existsByUserName(String username);

	Boolean existsByEmail(String email);

	@Query(value = "SELECT u.*\n" +
			"FROM user u\n" +
			"INNER JOIN user_roles x ON u.id = x.user_id\n" +
			"WHERE x.role_id = 2\n" +
			"AND u.id NOT IN (SELECT user_id FROM user_roles WHERE role_id = 1)",nativeQuery = true)
	List<User> findUserRole_User();
}
