package com.example.ui.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String username;
    private String password;

    public UserDTO(){
        super();
    }

    public UserDTO(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public UserDTO(String id,String username,String password){
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
