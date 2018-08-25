package com.example.ui.service.Impl;

import java.util.ArrayList;
import java.util.List;

import com.example.ui.domain.User;
import com.example.ui.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.example.ui.domain.Person;

@Service
public class PersonHystrixService {

    @Autowired
    PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave") //1
    public List<Person> save(String name) {
        return personService.save(name);
    }
    public List<Person> fallbackSave(String name) {
        List<Person> list = new ArrayList<>();
        Person p = new Person(name + "没有保存成功，Person Service 故障");
        list.add(p);
        return list;
    }

    @HystrixCommand(fallbackMethod = "fallbackLogin")
    public List<User> login(User user){
        return personService.login(user);
    }
    public List<User> fallbackLogin(User user){
        List<User> list = new ArrayList<>();
        User userItem = new User(user.getUsername()+ "  "+ user.getPassword()+"登录失败");
        list.add(userItem);
        return list;
    }
}
