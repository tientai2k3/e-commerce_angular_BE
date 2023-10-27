package WebProject.WebProject.service;

import java.util.List;

import WebProject.WebProject.entity.Color;
import WebProject.WebProject.entity.User;
import WebProject.WebProject.model.request.ColorRequest;
import WebProject.WebProject.model.request.SigninRequest;
import WebProject.WebProject.model.request.SignupRequest;
import WebProject.WebProject.model.request.UserRequest;

public interface UserService {
	List<User> findAll();
	User findById(Long id);
	User add(User user);
	User getUserByUserName(String username);
	User signup(SignupRequest request);


	User saveUser(UserRequest request);

	User updateUser(Long id, UserRequest request);

	void delete(Long id);

	List<User> findUserRole_User();
}
