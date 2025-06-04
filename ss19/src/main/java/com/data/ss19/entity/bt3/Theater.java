package com.data.ss19.entity.bt3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "Tên rạp không được để trống")
    private String theaterName;
    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;
    @Min(value = 1, message = "Số phòng chiếu phải lớn hơn 0")
    private Integer numberScreenRoom;
    private boolean status;

    public Theater() {
    }
    public Theater(long id, String theaterName, String address, Integer numberScreenRoom, boolean status) {
        this.id = id;
        this.theaterName = theaterName;
        this.address = address;
        this.numberScreenRoom = numberScreenRoom;
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getNumberScreenRoom() {
        return numberScreenRoom;
    }

    public void setNumberScreenRoom(Integer numberScreenRoom) {
        this.numberScreenRoom = numberScreenRoom;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }
}
