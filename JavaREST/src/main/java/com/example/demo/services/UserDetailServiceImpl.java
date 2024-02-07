package com.example.demo.services;

import com.example.demo.models.entity.UsersEntity;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UsersEntity> optionalUser = (userRepository.findByFirstName(userName));
        if (optionalUser.isPresent()) {
            UsersEntity user = optionalUser.get();

            return User.builder()
                    .username(user.getFirstName())
                    .password(String.valueOf((user.getPassword())))
                    .roles(user.getRole().name())
                    .build();
        } else {
            throw new UsernameNotFoundException("User Name is not Found");
        }
    }
}
