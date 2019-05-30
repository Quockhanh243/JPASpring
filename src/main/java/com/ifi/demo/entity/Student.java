package com.ifi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id_Student")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "birth")
    private Date birth;

    @JsonIgnore
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Set<CourseRegistration> courseRegistration;

    public Student() {

    }

    public Student(String name, Date birth) {
        this.name = name;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Set<CourseRegistration> getCourseRegistration() {
        return courseRegistration;
    }

    public void setCourseRegistrationSet(Set<CourseRegistration> courseRegistration) {
        this.courseRegistration = courseRegistration;
    }
}
