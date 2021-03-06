package com.example.ui.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http    .csrf().disable()
                .authorizeRequests()
                // 所有用户均可访问的资源
                .antMatchers("/css/**", "/js/**", "/images/**", "/tpl/**", "/resources/**", "/webjars/**", "**/favicon.ico", "/index").permitAll()
                // ROLE_USER的权限才能访问的资源
                .antMatchers("/user/**").hasRole("USER")
                // 任何尚未匹配的URL只需要验证用户即可访问
                .anyRequest().authenticated()
                .and()
                .formLogin()
                // 指定登录页面,授予所有用户访问登录页面
                .loginPage("/")
                .permitAll()
                .and()
                .headers()
                .frameOptions().sameOrigin();
        super.configure(http);
    }

}
