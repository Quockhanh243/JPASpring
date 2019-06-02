package com.ifi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "course")
public class Course {
    private int idCourse;
    private String fee;
    private String name;
    private Collection<CourseRegistration> courseRegistrationsByIdCourse;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_course")
    public int getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    @Basic
    @Column(name = "fee")
    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (idCourse != course.idCourse) return false;
        if (fee != null ? !fee.equals(course.fee) : course.fee != null) return false;
        if (name != null ? !name.equals(course.name) : course.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCourse;
        result = 31 * result + (fee != null ? fee.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "courseByIdCourse")
    @JsonIgnore
    public Collection<CourseRegistration> getCourseRegistrationsByIdCourse() {
        return courseRegistrationsByIdCourse;
    }

    public void setCourseRegistrationsByIdCourse(Collection<CourseRegistration> courseRegistrationsByIdCourse) {
        this.courseRegistrationsByIdCourse = courseRegistrationsByIdCourse;
    }

    public Course(String fee, String name) {
        this.fee = fee;
        this.name = name;
    }

    public Course() {
    }
}
