package com.yuexiang.wedding.provider.controller;

import com.yuexiang.wedding.domain.model.User;
import com.yuexiang.wedding.service.impl.WeddingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wedding")
public class WeddingUserController {
    @Autowired
    WeddingUserService weddingUserService;


    @RequestMapping(value = "/getuser")
     public User getUser(String openid){
         return weddingUserService.getUserByOpenId(openid);
     }

    @RequestMapping(value = "/adduser")
     public int addUser(User user){
         return weddingUserService.addUser(user);
     }

}
