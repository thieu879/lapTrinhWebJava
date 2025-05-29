package com.data.ss15.model.bt3;

import javax.validation.constraints.*;

public class User {
    @NotBlank(message = "Tên không được để trống")
    private String username;
    @Size(min = 6, max = 20, message = "Mật khẩu phải từ {min} đến {max} ký tự")
    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;
    @Email(message = "Email không hợp lệ")
    private String email;

    public User() {
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
