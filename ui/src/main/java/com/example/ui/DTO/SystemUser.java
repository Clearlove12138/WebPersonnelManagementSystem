package com.example.ui.DTO;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class SystemUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String username;
    private String password;

//    private List<String> role;

    public SystemUser(){}

    public SystemUser(SystemUser user){
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.id = user.getId();
//        this.role = user.getRole();
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
/*
    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
    */
}
