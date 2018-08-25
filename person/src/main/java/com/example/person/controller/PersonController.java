package com.example.person.controller;


import java.util.List;
import java.util.UUID;

import com.example.person.dao.PersonRepository;
import com.example.person.dao.UserRepository;
import com.example.person.domain.Person;
import com.example.person.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Person> savePerson(@RequestBody String  personName) {
    	Person p = new Person(personName);
    	personRepository.save(p);
    	List<Person> people = personRepository.findAll(new PageRequest(0, 10)).getContent();
        return people;
    }

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public List<User> login(@RequestBody User user){
        User userItem = new User(UUID.randomUUID().toString(),user.getUsername(),user.getPassword());
        userRepository.save(userItem);
        List<User> users = userRepository.findAll(new PageRequest(0,10)).getContent();
        return users;
    }


}
