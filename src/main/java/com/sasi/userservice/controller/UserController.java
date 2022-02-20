package com.sasi.userservice.controller;

import com.sasi.userservice.VO.ResponseTemplateVO;
import com.sasi.userservice.entity.User;
import com.sasi.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user)
    {
        log.info("inside userController method");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable ("id") Long id)
    {
        return userService.getUserWithDepartment(id);
    }


}
