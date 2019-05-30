package com.ifi.demo.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class CourseRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_CourseReg")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "Id_Student")
    private Student student;

    @ManyToOne()
    @JoinColumn(name = "Id_Course")
    private Course course;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;

    public CourseRegistration() {
    }

    public CourseRegistration(Student student, Course course, Date startDate, Date endDate) {
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
