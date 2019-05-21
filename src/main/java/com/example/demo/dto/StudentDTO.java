package com.example.demo.dto;

import com.example.demo.utile.EGender;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author david
 */
public class StudentDTO {

    @NotNull
    private String name;
    @Email
    @NotNull
    private String email;
    private String username;
    private EGender gender;
    @Pattern(regexp = "[0-9|a-z|A-Z|!@#$%^&*()_-]{8,}")
    @NotNull
    @NotBlank
    private String password;
    private Date DOB;

    public StudentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public EGender getGender() {
        return gender;
    }

    public void setGender(EGender gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

}
