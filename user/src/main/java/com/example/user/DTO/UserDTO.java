package com.example.user.DTO;

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
}
