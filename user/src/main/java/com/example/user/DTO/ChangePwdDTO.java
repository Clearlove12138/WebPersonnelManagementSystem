package com.example.user.DTO;

import lombok.Data;

@Data
public class ChangePwdDTO {
    private String id;
    private String username;
    private String password;
    private String newPwd;
    private String confirmPwd;

    public ChangePwdDTO(){
        super();
    }

    public ChangePwdDTO(String username,String password ){
        super();
        this.username = username;
        this.password = password;
    }

    public ChangePwdDTO(String username,String password,String newPwd,String confirmPwd){
        super();
        this.username = username;
        this.password = password;
        this.newPwd = newPwd;
        this.confirmPwd = confirmPwd;
    }
}
