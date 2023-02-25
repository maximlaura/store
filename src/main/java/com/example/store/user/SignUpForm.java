package com.example.store.user;

import org.hibernate.validator.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class SignUpForm {

    @NotEmpty
    @Size(min=10,max=30)
    private String username="";

    @NotEmpty
    @Size(min=1,max=30)
    private String firstName="";

    @NotEmpty
    @Size(min=1,max=30)
    private String lastName="";

    @NotEmpty
    @Size(min=7, max=45)
    private String password = "";

    @NotEmpty
    @Size(min=7, max=30)
    private String passwordCheck = "";

    @NotEmpty
    private String role = "USER";

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

    public String getPasswordCheck() {
        return passwordCheck;
    }

    public void setPasswordCheck(String passwordCheck) {
        this.passwordCheck = passwordCheck;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}