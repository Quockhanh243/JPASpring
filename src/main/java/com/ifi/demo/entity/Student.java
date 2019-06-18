package com.ifi.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "student")
public class Student {
    private int idStudent;
    private Timestamp birth;
    private String name;
    private Collection<CourseRegistration> courseRegistrationsByIdStudent;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_student")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "birth")
    public Timestamp getBirth() {
        return birth;
    }

    public void setBirth(Timestamp birth) {
        this.birth = birth;
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

        Student student = (Student) o;

        if (idStudent != student.idStudent) return false;
        if (birth != null ? !birth.equals(student.birth) : student.birth != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudent;
        result = 31 * result + (birth != null ? birth.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studentByIdStudentss")
    @JsonIgnore
    public Collection<CourseRegistration> getCourseRegistrationsByIdStudent() {
        return courseRegistrationsByIdStudent;
    }

    public void setCourseRegistrationsByIdStudent(Collection<CourseRegistration> courseRegistrationsByIdStudent) {
        this.courseRegistrationsByIdStudent = courseRegistrationsByIdStudent;
    }

    public Student( String name, Timestamp birth) {
        this.birth = birth;
        this.name = name;
    }

    public Student() {
    }
}
