package de.sveri.cleanercomm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public class User {
    @GeneratedValue
    @Id
    private Long id;
    
    @NotNull
    @Size(min = 3, max = 100, message = "Username must at least 3 characters.")
    private String userName;
    
    @NotNull
    @Size(min = 3, max = 100, message = "Password must at least 3 characters.")
    private String password;
    
    @Transient
    private String confirmPassword;
    
    @Email(message = "Email address is not valid.")
    @NotNull
    private String email;
    
    private String token;
    
    private String role = "ROLE_USER";
    
    private String lastLogin;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }
    
    public Boolean isAdmin() {
        return this.role.equals("ROLE_ADMIN");
    }
    
    public Boolean isMatchingPasswords() {
        return this.password.equals(this.confirmPassword);
    }
}