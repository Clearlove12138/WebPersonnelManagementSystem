package com.example.ui.service;

import com.example.ui.DTO.ChangePwdDTO;
import com.example.ui.DTO.UserDTO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("user")
public interface UserService {
    @RequestMapping(method = RequestMethod.GET, value = "/getAllUser",
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    List<UserDTO> getAllUser();

    @RequestMapping(method = RequestMethod.POST,value = "/loginUser",
            produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String loginUser(@RequestBody UserDTO user);

    @RequestMapping(method = RequestMethod.PUT,value = "/changePwd",
            produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    String changePwd(@RequestBody ChangePwdDTO changePwd);
}
