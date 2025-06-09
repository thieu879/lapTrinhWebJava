package com.data.exam_webapp.entity;

import org.hibernate.annotations.Check;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Check(constraints = "LENGTH(id) = 5")
public class Student {
    @Id
    @Column(columnDefinition = "char(5)")
    private String id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autoId", nullable = false, unique = true)
    private Long autoId;
    @Column(nullable = false, columnDefinition = "VARCHAR(200)")
    private String name;
    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(100)")
    private String email;
    @Column(unique = true, nullable = false, columnDefinition = "VARCHAR(15)")
    private String phone;
    @Column(nullable = false)
    private int sex;
    @Column(nullable = false)
    private LocalDate bod;
    private String avatar;
    @Column(nullable = false)
    private boolean status;

    @PrePersist
    public void prePersist() {
        if (this.id == null && this.autoId != null) {
            this.id = String.format("SV%03d", this.autoId);
        }
    }

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses;
    public Student() {
    }

    public Student(String id, Long autoId, String name, String email, String phone, int sex, LocalDate bod, String avatar, boolean status, Set<Course> courses) {
        this.id = id;
        this.autoId = autoId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.bod = bod;
        this.avatar = avatar;
        this.status = status;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAutoId() {
        return autoId;
    }

    public void setAutoId(Long autoId) {
        this.autoId = autoId;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public LocalDate getBod() {
        return bod;
    }

    public void setBod(LocalDate bod) {
        this.bod = bod;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
