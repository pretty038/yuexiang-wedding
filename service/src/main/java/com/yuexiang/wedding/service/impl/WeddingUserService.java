package com.yuexiang.wedding.service.impl;

import com.yuexiang.wedding.dao.UserDAO;
import com.yuexiang.wedding.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeddingUserService {

    @Autowired
    UserDAO userDAO;

    public User getUserByOpenId(String openid){
        User user=userDAO.getUserByOpenId(openid);
        if(user==null){
            return new User();
        }
        return user;
    }

    public int addUser(User user){
        return userDAO.addUser(user);
    }




}
