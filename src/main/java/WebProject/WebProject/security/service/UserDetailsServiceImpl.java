package WebProject.WebProject.security.service;

import WebProject.WebProject.entity.User;
import WebProject.WebProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        User user = userRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

        // if(user != null && user.isEnabled()){

        //     return UserDetailsImpl.build(user);
        // }else{
        //     throw new UsernameNotFoundException("User Not Found with username: " + username);
        // }

        return UserDetailsImpl.build(user);


    }
}
