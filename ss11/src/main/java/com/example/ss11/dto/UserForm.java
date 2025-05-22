package com.example.ss11.dto;

import com.example.ss11.validation.PhoneNumber;
import javax.validation.constraints.NotBlank;

public class UserForm {

    @NotBlank(message = "Số điện thoại không được để trống")
    @PhoneNumber
    private String phoneNumber;
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
