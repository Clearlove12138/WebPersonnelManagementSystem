package com.example.user.service.Impl;

import com.example.user.DTO.ChangePwdDTO;
import com.example.user.DTO.UserDTO;
import com.example.user.mapper.UserMapper;
import com.example.user.service.IuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userService")
public class UserServiceImpl implements IuserService {
    @Autowired
    UserMapper userMapper;

    public List<UserDTO> getAll(){
        return userMapper.getAll();
    }

    public String loginUser(UserDTO user){
        UserDTO userInfo =  userMapper.loginUser(user);
        if (userInfo != null){
            return userInfo.getUsername() + " 登录成功";
        }else {
            return "用户名或密码错误,请重新登录";
        }
    }

    public String changePwd(ChangePwdDTO changePwd){
        int resultInt = -1;
        if (changePwd.getConfirmPwd().equals(changePwd.getNewPwd())){
            if (changePwd.getPassword().equals(changePwd.getNewPwd())){
                System.out.println("User-UserServiceImpl-changePwd: 新旧密码相同,请重新输入");
                return "新旧密码相同,请重新输入";
            }
            resultInt = userMapper.changePwd(changePwd);
        }else{
            System.out.println("User-UserServiceImpl-changePwd: 两次输入的密码不一致，请重新输入");
            return "两次输入的密码不一致，请重新输入";
        }
        if (resultInt > 0){
            System.out.println("User-UserServiceImpl-changePwd: 密码修改成功");
            return "密码修改成功";
        }else{
            System.out.println("User-UserServiceImpl-changePwd: 用户名或密码错误，请重新输入");
            return "用户名或密码错误，请重新输入";
        }
    }
}
