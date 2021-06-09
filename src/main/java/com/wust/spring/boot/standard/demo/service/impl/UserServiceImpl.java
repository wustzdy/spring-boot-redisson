package com.wust.spring.boot.standard.demo.service.impl;


import com.wust.spring.boot.standard.demo.entity.UserEntity;
import com.wust.spring.boot.standard.demo.mapper.UserMapper;
import com.wust.spring.boot.standard.demo.model.User;
import com.wust.spring.boot.standard.demo.service.UserService;
import com.wust.spring.boot.standard.demo.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User addUser(User user) {
        log.info("创建user请求参数user：. user=[{}]", JacksonUtil.bean2Json(user));
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        if (userMapper.insert(userEntity) != 1) {
            throw new RuntimeException("error");
        }
        User user1 = new User();
        BeanUtils.copyProperties(userEntity, user1);
        log.info("创建user返回参数user1：. user1=[{}]", JacksonUtil.bean2Json(user1));
        return user1;
    }

    @Override
    public User getUser(String userName) {
        UserEntity userEntity = userMapper.selectByName(userName);
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }
}
