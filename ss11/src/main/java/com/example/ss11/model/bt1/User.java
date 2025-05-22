package com.example.ss11.model.bt1;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
    @NotBlank(message = "Tên không được để trống")
    @Size(min = 2, max = 30, message = "Tên phải từ 2 đến 30 ký tự")
    private String name;
    @NotBlank(message = "Email không được để trống")
    @Size(min = 2, max = 30, message = "email phải từ 2 đến 30 ký tự")
    @Email(message = "Email không hợp lệ")
    private String email;
    @NotBlank(message = "Số điện thoại không được để trống")
    @Size(min = 10, max = 12, message = "Số điện thoại phải từ 10 đến 12 ký tự")
    private String phone;
    @NotBlank(message = "Mật khẩu không được để trống")
    @Size(min = 6, max = 20, message = "Mật khẩu phải từ 6 đến 20 ký tự")
    private String password;
    @NotNull(message = "Trạng thái không được để trống")
    private boolean status;

    public User() {
    }

    public User(String name, String email, String phone, String password, boolean status) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
