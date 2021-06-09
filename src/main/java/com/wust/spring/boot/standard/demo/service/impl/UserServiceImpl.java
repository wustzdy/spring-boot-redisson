package com.wust.spring.boot.standard.demo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wust.spring.boot.standard.demo.constant.page.PageResult;
import com.wust.spring.boot.standard.demo.entity.UserEntity;
import com.wust.spring.boot.standard.demo.mapper.UserMapper;
import com.wust.spring.boot.standard.demo.model.User;
import com.wust.spring.boot.standard.demo.model.request.UserRequest;
import com.wust.spring.boot.standard.demo.service.UserService;
import com.wust.spring.boot.standard.demo.util.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


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

    public PageResult<User> queryUserPage(UserRequest request) {
        QueryWrapper<UserEntity> wrapper = new QueryWrapper<>();
        wrapper.like("user_name", request.getName());

        Page<UserEntity> page = new Page<>(request.getPageRequire().getPage(), request.getPageRequire().getPageSize());
        Page<UserEntity> userIPage = userMapper.selectPage(page, wrapper);


        List<User> list = userIPage.getRecords().stream().map(
                en -> new User().setUserName(en.getUserName())
                        .setPassWord(en.getPassWord())
                        .setId(en.getId())
        ).collect(Collectors.toList());

        return new PageResult<User>()
                .setTotal(userIPage.getTotal())
                .setPage(userIPage.getCurrent())
                .setPageSize(userIPage.getSize())
                .setRecords(list);
    }
}
