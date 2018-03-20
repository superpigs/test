package com.zhulei.test.controller;

import com.zhulei.test.entity.Users;
import com.zhulei.test.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
@CrossOrigin
@Controller
public class UserController {
    @Resource
    UsersService usersService;
    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Users login(String uname, String upwd){
        System.out.println("login=====");
        Users users = usersService.login(uname,upwd);
        return users;
    }
    @ResponseBody
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public Users regist(Users users){
        System.out.println("====regist=====");
        return usersService.regist(users);
    }
}
