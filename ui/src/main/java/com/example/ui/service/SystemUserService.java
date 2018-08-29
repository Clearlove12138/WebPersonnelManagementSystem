package com.example.ui.service;

import com.example.ui.DTO.SystemUser;
import com.example.ui.DTO.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("SystemUserServiceImpl")
public interface SystemUserService extends JpaRepository<SystemUser,String> {
    SystemUser findByUsername(String username);
}
