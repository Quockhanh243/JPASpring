package com.ifi.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_CourseReg")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Student")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_Course")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Course course;

    @Column(name = "start_date")
    LocalDateTime startDate;

    @Column(name = "end_date")
    LocalDateTime endDate;

    public CourseRegistration() {
    }

    public CourseRegistration(Student student, Course course, LocalDateTime startDate, LocalDateTime endDate) {
        this.student = student;
        this.course = course;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
