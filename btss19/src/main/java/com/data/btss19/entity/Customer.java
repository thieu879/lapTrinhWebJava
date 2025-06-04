package com.data.btss19.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "First name không được để trống")
    @Size(min = 3, max = 10, message = "First name phải từ 3 đến 10 ký tự")
    private String FirstName;
    @NotBlank(message = "Last name không được để trống")
    @Size(min = 3, max = 10, message = "Last name phải từ 3 đến 10 ký tự")
    private String LastName;
    private String phone;
    private String address;
    private String fileImage;

    public Customer() {
    }
    public Customer(int id, String firstName, String lastName, String phone, String address, String fileImage) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;
        this.phone = phone;
        this.address = address;
        this.fileImage = fileImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFileImage() {
        return fileImage;
    }

    public void setFileImage(String fileImage) {
        this.fileImage = fileImage;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
