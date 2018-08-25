package com.example.user.service;

import com.example.user.DTO.ChangePwdDTO;
import com.example.user.DTO.UserDTO;

import java.util.List;

public interface IuserService {
    List<UserDTO> getAll();

    String loginUser(UserDTO user);

    String changePwd(ChangePwdDTO changePwd);
}
