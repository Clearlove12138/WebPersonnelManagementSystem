package com.example.ui.service;

import com.example.ui.DTO.MyUserDetails;
import com.example.ui.DTO.SystemUser;
import com.example.ui.DTO.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service("MyUserDetailsImpl")
public class MyUserDetailsService implements UserDetailsService {
    @Resource(name = "SystemUserServiceImpl")
    private SystemUserService systemUserService;

    @Resource(name = "UserRoleServiceImpl")
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        SystemUser user;
        try {
            user = systemUserService.findByUsername(userName);
//            log.debug("UserRoleService - loadUserByUsername - username: ",userName);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail");
        }
        if(user == null){
            throw new UsernameNotFoundException("no user found");
        } else {
            try {
                /*
                List<UserRole> roles = new ArrayList<>();
                UserRole userRole = new UserRole();
                userRole.setId("1");
                userRole.setRole("USER");
                userRole.setUserId("1");
                roles.add(userRole);
                */
                List<UserRole> roles = userRoleService.getRoleByUserId(user.getId());
//                log.debug("UserRoleService - loadUserByUsername - roles: ",roles);
                return new MyUserDetails(user, roles);
            } catch (Exception e) {
                throw new UsernameNotFoundException("user role select fail");
            }
        }
    }
}