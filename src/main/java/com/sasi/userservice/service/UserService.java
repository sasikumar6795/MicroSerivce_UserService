package com.sasi.userservice.service;

import com.sasi.userservice.VO.Department;
import com.sasi.userservice.VO.ResponseTemplateVO;
import com.sasi.userservice.entity.User;
import com.sasi.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside userServiceMethod");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {
        log.info("inside getUserWithDepartment service method");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user=userRepository.findByUserId(id);
        log.info("userObject " + user.toString());

        Department department=
                restTemplate.getForObject("http://localhost:9091/departments/" + user.getDepartmentId() ,Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;





    }
}
