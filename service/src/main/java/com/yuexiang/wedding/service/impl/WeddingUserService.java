package com.yuexiang.wedding.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yuexiang.wedding.common.helper.HttpClientUtil;
import com.yuexiang.wedding.dao.UserDAO;
import com.yuexiang.wedding.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeddingUserService {

    @Autowired
    UserDAO userDAO;

    public User getUserByOpenId(String openId){
        User user=userDAO.getUserByOpenId(openId);
        if(user==null){
            return new User();
        }
        return user;
    }

    public int addUser(User user){
        return userDAO.addUser(user);
    }

    public JSONObject getOpenId(String code){
        String url="https://api.weixin.qq.com/sns/jscode2session?appid=wx9222a867ef776cba&secret=2433a35f36518cd5d7007919ce355475&js_code=CODE&grant_type=authorization_code";
        return HttpClientUtil.doGet(url.replace("CODE",code));
    }




}
