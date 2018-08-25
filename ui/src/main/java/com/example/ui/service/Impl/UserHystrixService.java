package com.example.ui.service.Impl;

import com.example.ui.DTO.ChangePwdDTO;
import com.example.ui.DTO.UserDTO;
import com.example.ui.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserHystrixService {
    @Autowired
    UserService userService;

    @HystrixCommand(fallbackMethod = "fallbackGetAllUser") //1
    public List<UserDTO> getAllUser() {
        return userService.getAllUser();
    }

    public List<UserDTO> fallbackGetAllUser() {
        List<UserDTO> list = new ArrayList<>();
        UserDTO p = new UserDTO("user", "获取失败");
        list.add(p);
        return list;
    }

    @HystrixCommand(fallbackMethod = "fallbackLoginUser")
    public String loginUser(UserDTO user) {
        System.out.println("UI-UserHystrixService-loginUser: " + user.getUsername() +"  "+ user.getPassword());
        return userService.loginUser(user);
    }

    public String fallbackLoginUser(UserDTO user) {
        return "网络错误," + user + "登录失败";
    }


    @HystrixCommand(fallbackMethod = "fallbackChangePwd")
    public String changePwd(ChangePwdDTO changePwd) {
        System.out.println("UI-UserHystrixService-changePwd: " + changePwd.getUsername() +" "+ changePwd.getPassword() +" "+ changePwd.getNewPwd()+ " " +changePwd.getConfirmPwd());
        return userService.changePwd(changePwd);
    }

    public String fallbackChangePwd(ChangePwdDTO changePwd) {
        return "网络错误," + changePwd.getUsername() + "密码修改失败";
    }
}
