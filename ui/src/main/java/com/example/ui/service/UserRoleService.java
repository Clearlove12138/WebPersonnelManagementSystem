package com.example.ui.service;

import com.example.ui.DTO.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("UserRoleServiceImpl")
public interface UserRoleService extends JpaRepository<UserRole,String> {
    List<UserRole> getRoleByUserId(String userId);
}
