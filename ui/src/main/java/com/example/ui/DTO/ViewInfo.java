package com.example.ui.DTO;

import java.io.Serializable;

    public class ViewInfo implements Serializable {

        private SystemUser systemUser;
        private UserRole userRole;
        public ViewInfo(){

        }
        public ViewInfo(SystemUser systemUser){
            UserRole userRole = new UserRole();
            this.systemUser = systemUser;
            this.userRole = userRole;
        }
        public ViewInfo(UserRole userRole){
            SystemUser systemUser = new SystemUser();
            this.systemUser = systemUser;
            this.userRole = userRole;
        }
        public ViewInfo(SystemUser systemUser,UserRole userRole){
            this.systemUser = systemUser;
            this.userRole = userRole;
        }
        // getter and setter

        public SystemUser getSystemUser() {
            return systemUser;
        }

        public void setSystemUser(SystemUser systemUser) {
            this.systemUser = systemUser;
        }

        public UserRole getUserRole() {
            return userRole;
        }

        public void setUserRole(UserRole userRole) {
            this.userRole = userRole;
        }
    }
