package com.ifi.demo.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "course_registration")
public class CourseRegistration {
    private int idCourseReg;
    private Timestamp endDate;
    private Timestamp startDate;
    private Course courseByIdCourse;
    private Student studentByIdStudentss;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_course_reg")
    public int getIdCourseReg() {
        return idCourseReg;
    }

    public void setIdCourseReg(int idCourseReg) {
        this.idCourseReg = idCourseReg;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseRegistration that = (CourseRegistration) o;

        if (idCourseReg != that.idCourseReg) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCourseReg;
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    public Course getCourseByIdCourse() {
        return courseByIdCourse;
    }

    public void setCourseByIdCourse(Course courseByIdCourse) {
        this.courseByIdCourse = courseByIdCourse;
    }

    @ManyToOne
    @JoinColumn(name = "id_studentss", referencedColumnName = "id_student")
    public Student getStudentByIdStudentss() {
        return studentByIdStudentss;
    }

    public void setStudentByIdStudentss(Student studentByIdStudentss) {
        this.studentByIdStudentss = studentByIdStudentss;
    }
}
