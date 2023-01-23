package com.fiveExceptions.service;

import com.fiveExceptions.dto.AuthRequest;
import com.fiveExceptions.dto.UserRequest;
import com.fiveExceptions.entity.User;
import com.fiveExceptions.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public void createUser(UserRequest userRequest) {
        User user = User.builder()
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .roles(userRequest.getRoles())
                .build();
        userRepository.save(user);
        log.info("User {} is saved", user.getId());

    }
}
