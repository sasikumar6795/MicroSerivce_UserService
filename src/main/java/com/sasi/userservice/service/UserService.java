package com.sasi.userservice.service;

import com.sasi.userservice.entity.User;
import com.sasi.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User saveUser(User user) {
        log.info("inside userServiceMethod");
        return userRepository.save(user);
    }
}
