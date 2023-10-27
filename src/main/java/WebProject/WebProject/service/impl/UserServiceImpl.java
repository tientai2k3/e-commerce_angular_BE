package WebProject.WebProject.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import WebProject.WebProject.entity.Color;
import WebProject.WebProject.entity.ERole;
import WebProject.WebProject.entity.Role;
import WebProject.WebProject.model.request.SigninRequest;
import WebProject.WebProject.model.request.SignupRequest;
//import WebProject.WebProject.model.request.UserRequest;
import WebProject.WebProject.model.request.UserRequest;
import WebProject.WebProject.repository.RoleRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import WebProject.WebProject.entity.User;
import WebProject.WebProject.repository.UserRepository;
import WebProject.WebProject.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepository.findByUserName(username).get();
    }

    @Override
    public User signup(SignupRequest request) {
        User user = new User();
        user.setUserName(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));
        Set<String> strRoles = request.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                        break;

                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        return (userRepository.save(user));
    }

    @Override
    public User saveUser(UserRequest request) {
        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(userRole);
        User user = new User();
        user.setRoles(roles);
        if (userRepository.existsByUserName(request.getUserName())){
            return null;
        }
        user.setUserName(request.getUserName());
        if (userRepository.existsByEmail(request.getEmail())){
            return null;
        }
        user.setPassword(encoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setPhone_Number(request.getPhone_Number());
        user.setFullName(request.getFullName());
        user.setAddress(request.getAddress());
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserRequest request) {
        User user = userRepository.findById(id).get();
        System.out.println(user.getId()+ " caaaaaaaaa");
        user.setUserName(request.getUserName());
//        if (userRepository.existsByUserName(request.getUserName())){
//            return null;
//        }
//        if (userRepository.existsByEmail(request.getEmail())){
//            return null;
//        }
        user.setEmail(request.getEmail());
        user.setPhone_Number(request.getPhone_Number());
        if (request.getPassword()!=null){
            user.setPassword(encoder.encode(request.getPassword()));
        }

        user.setFullName(request.getFullName());
        user.setAddress(request.getAddress());
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> findUserRole_User() {
        return userRepository.findUserRole_User();
    }


}
