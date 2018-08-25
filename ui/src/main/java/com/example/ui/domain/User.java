package com.example.ui.domain;

import lombok.Data;

@Data
public class User {
    private String id;
    private String username;
    private String password;

    public User(){
        super();
    }

    public User(String username){
        super();
        this.username = username;
    }
    public User(String id,String username,String password){
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
