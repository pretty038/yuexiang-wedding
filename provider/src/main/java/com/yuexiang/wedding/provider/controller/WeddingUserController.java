package com.yuexiang.wedding.provider.controller;

import com.yuexiang.wedding.domain.model.User;
import com.yuexiang.wedding.service.impl.WeddingUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wedding/user")
public class WeddingUserController {
    @Autowired
    WeddingUserService weddingUserService;


    @RequestMapping(value = "/getuser")
     public User getUser(@RequestParam(value = "openId") String openId){
         return weddingUserService.getUserByOpenId(openId);
     }

    @RequestMapping(value = "/adduser")
     public int addUser(User user){
         return weddingUserService.addUser(user);
     }

    @RequestMapping(value = "/sendCode")
     public String sendCode(@RequestParam(value = "mobile") String mobile){
        return "{\"status\":\"SUCCESS\",\"msg\":\"send code success!\"}";
     }

    @RequestMapping(value = "/checkcode")
    public String checkCode(@RequestParam(value = "mobile") String mobile,String code){
        return "{\"status\":\"SUCCESS\",\"msg\":\"check code success!\"}";
    }


}
