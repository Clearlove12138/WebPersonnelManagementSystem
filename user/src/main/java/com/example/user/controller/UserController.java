package com.example.user.controller;

import com.example.user.DTO.ChangePwdDTO;
import com.example.user.DTO.UserDTO;
import com.example.user.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
//@RequestMapping("/user")
public class UserController {

    @Qualifier("userService")
    @Autowired
    private IuserService iuserService;

    @ResponseBody
    @GetMapping("/getAllUser")
    public List<UserDTO> getAllUser(){
        return iuserService.getAll();
    }

    @ResponseBody
    @PostMapping("/loginUser")
    public String loginUser(@RequestBody UserDTO user){
        System.out.println("User-UserService-loginUser: " + user.getUsername() +"  "+ user.getPassword());
        return iuserService.loginUser(user);
    }

    @ResponseBody
    @PutMapping("/changePwd")
    public String changePwd(@RequestBody ChangePwdDTO changePwd){
        System.out.println("User-UserController-changePwd: " + changePwd.getUsername() +" "+ changePwd.getPassword() +" "+ changePwd.getNewPwd() +" "+ changePwd.getConfirmPwd());
        return iuserService.changePwd(changePwd);
    }
}
