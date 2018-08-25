package com.example.ui.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.ui.DTO.ChangePwdDTO;
import com.example.ui.DTO.UserDTO;
import com.example.ui.domain.Person;
import com.example.ui.domain.User;
import com.example.ui.service.Impl.PersonHystrixService;
import com.example.ui.service.Impl.UserHystrixService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.ui.service.Impl.SomeHystrixService;

import javax.servlet.http.HttpServletResponse;

@Api(value = "UI模块",tags ="UI模块接口")
@RestController
public class UiController {
    @Autowired
    private SomeHystrixService someHystrixService;

    @Autowired
    private PersonHystrixService personHystrixService;

    @PostMapping("/dispatch")
    public List<Person> sendMessage(@RequestBody String personName) {
        return personHystrixService.save(personName);
    }

    @GetMapping(value = "/getsome", produces = {MediaType.TEXT_PLAIN_VALUE})
    public String getSome() {
        return someHystrixService.getSome();
    }

    @PostMapping(value = "/login")
    public List<User> login(@RequestBody User user) {
		return personHystrixService.login(user);
    }

    @Autowired
    UserHystrixService userHystrixService;

    @ApiOperation(value = "获取",notes = "获取全部用户信息")
    @ResponseBody
    @GetMapping(value = "/getAllUser")
    public List<UserDTO> getAllUser(){
        return userHystrixService.getAllUser();
    }

    @ApiOperation(value = "用户登录",notes = "用户登录")
//    @ResponseBody
    @PostMapping(value = "/loginUser")
    public void loginUser(@RequestBody UserDTO user, HttpServletResponse response){
        String result = userHystrixService.loginUser(user);
        System.out.println("Ui loginUser Controller: "+user.getUsername() +" "+result);
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.append(result);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (out != null){
                out.close();
            }
        }
    }

    @ApiOperation(value = "用户密码修改",notes = "用户密码修改")
    @PostMapping(value = "/changePwd")
//    @ResponseBody
    public void changePwd(@RequestBody ChangePwdDTO changePwd,HttpServletResponse response){
        changePwd.setConfirmPwd(changePwd.getNewPwd());
        System.out.println("UI-UIController-changePwd: " + changePwd.getUsername() +"  "+ changePwd.getPassword() +"  " +changePwd.getNewPwd()+ " " +changePwd.getConfirmPwd());
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = null;
        try{
            out = response.getWriter();
            out.append(userHystrixService.changePwd(changePwd));
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (out != null){
                out.close();
            }
        }
    }
}
