package com.ifi.demo.service;

import com.ifi.demo.entity.Course;
import com.ifi.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional(rollbackFor = Exception.class)
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Set<Course> getAll(){
        System.out.println("Get all course ...");
        Set<Course> courses = new HashSet<>();
        courseRepository.findAll().forEach(courses::add);
        return courses;
    }

    public Course createCourse(Course course){
        Course _course = courseRepository.save(new Course(course.getName(), course.getFee()));
        System.out.println("Course has been Created....");
        return _course;
    }

    public ResponseEntity<String> deleteCourse(int id){
        System.out.println("Delete Course with ID = " + id + "...");

        courseRepository.deleteById(id);

        return new ResponseEntity<>("Course has been deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> updateCourse(int id, Course course){
        System.out.println("Update Course with ID= "+id+".......");

        Optional<Course> courseRegistrationData = courseRepository.findById(id);
        if(courseRegistrationData.isPresent()){
            Course _course = courseRegistrationData.get();
            course.setName(course.getName());
            course.setFee(course.getFee());
            courseRepository.save(_course);
        }
        return new ResponseEntity<>("Course has been updated",HttpStatus.OK);
    }

    public Course findCourseById(int id){
        return courseRepository.findById(id).get();
    }
}
