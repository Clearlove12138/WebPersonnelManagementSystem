package com.example.user.mapper;

import com.example.user.DTO.ChangePwdDTO;
import com.example.user.DTO.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<UserDTO> getAll();

    UserDTO loginUser(UserDTO user);

    int changePwd(ChangePwdDTO changePwd);
}
