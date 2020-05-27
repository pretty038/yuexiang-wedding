package com.yuexiang.wedding.provider.controller;

import com.yuexiang.wedding.domain.model.CommonStatus;
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

    @RequestMapping(value = "/sendcode")
     public CommonStatus sendCode(@RequestParam(value = "mobile") String mobile){
        return new CommonStatus("SUCCESS","send code success!");
     }

    @RequestMapping(value = "/checkcode")
    public CommonStatus checkCode(@RequestParam(value = "mobile") String mobile,String code){
        return new CommonStatus("SUCCESS","check code success!");
    }




}
