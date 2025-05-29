package com.data.ss15.model.bt10;

import javax.validation.constraints.*;

public class Resume {
    private Long id;

    @NotBlank(message = "{resume.fullName.notBlank}")
    private String fullName;

    @NotBlank(message = "{resume.email.notBlank}")
    @Email(message = "{resume.email.valid}")
    private String email;

    @NotBlank(message = "{resume.phone.notBlank}")
    @Pattern(regexp = "^\\d{10,11}$", message = "{resume.phone.valid}")
    private String phoneNumber;

    private String education;
    private String experience;
    private String skills;

    public Resume() {
    }
    public Resume(Long id, String fullName, String email, String phoneNumber, String education, String experience, String skills) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.education = education;
        this.experience = experience;
        this.skills = skills;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}

