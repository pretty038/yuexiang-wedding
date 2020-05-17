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
        User user=new User();
        user.setOpenId(openid);
        User user1=userDAO.getUser(user);
        return user1;
    }

    public int addUser(User user){
        return userDAO.addUser(user);
    }




}
