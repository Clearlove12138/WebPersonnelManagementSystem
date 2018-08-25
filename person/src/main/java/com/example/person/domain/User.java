package com.example.person.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    private String id;

    private String username;
    private String password;

    public User(){
        super();
    }
    public User(String username,String password){
        super();
        this.username = username;
        this.password = password;
    }
    public User(String id,String username,String password){
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
