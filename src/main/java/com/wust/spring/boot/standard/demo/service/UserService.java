package com.wust.spring.boot.standard.demo.service;

import com.wust.spring.boot.standard.demo.constant.page.PageRequire;
import com.wust.spring.boot.standard.demo.constant.page.PageResult;
import com.wust.spring.boot.standard.demo.model.User;
import com.wust.spring.boot.standard.demo.model.request.UserRequest;

public interface UserService {
    User addUser(User user);

    User getUser(String userName);

    public PageResult<User> queryUserPage(UserRequest request);

    public PageResult<User> list(PageRequire pageRequire, String name);
}
