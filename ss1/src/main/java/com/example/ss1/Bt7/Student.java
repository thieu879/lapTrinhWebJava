package com.example.ss1.Bt7;

public class Student {
    private String fullName;
    private String studentClass;
    private String vehicleType;
    private String licensePlate;

    public Student(String fullName, String studentClass, String vehicleType, String licensePlate) {
        this.fullName = fullName;
        this.studentClass = studentClass;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    public String getFullName() {
        return fullName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}
