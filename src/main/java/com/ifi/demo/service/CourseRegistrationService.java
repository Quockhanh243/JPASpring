package com.ifi.demo.service;

import com.ifi.demo.entity.CourseRegistration;
import com.ifi.demo.repository.CourseRegistrationRepository;
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
public class CourseRegistrationService {
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    public Set<CourseRegistration> getAll(){
        System.out.println("Get all course ...");
        Set<CourseRegistration> courseRegistrations = new HashSet<>();
        courseRegistrationRepository.findAll().forEach(courseRegistrations::add);
        return courseRegistrations;
    }

    public CourseRegistration CreateCourseRegistration(CourseRegistration courseRegistration){
        CourseRegistration _courseRegistration = courseRegistrationRepository.save(courseRegistration);
        System.out.println("Course Registration Created....");
        return _courseRegistration;
    }

    public ResponseEntity<String> deleteCourseRegistration(int id){
        System.out.println("Delete Course Registration with ID = " + id + "...");

        courseRegistrationRepository.deleteById(id);

        return new ResponseEntity<>("Course Registration has been deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> updateCourseRegistration(int id, CourseRegistration courseRegistration){
        System.out.println("Update Course Registration with ID= "+id+".......");

        Optional<CourseRegistration> courseRegistrationData = courseRegistrationRepository.findById(id);

        if(courseRegistrationData.isPresent()){
            CourseRegistration _courseRegistration = courseRegistrationData.get();
            _courseRegistration.setStudentByIdStudentss(courseRegistration.getStudentByIdStudentss());
            _courseRegistration.setCourseByIdCourse(courseRegistration.getCourseByIdCourse());
            _courseRegistration.setStartDate(courseRegistration.getStartDate());
            _courseRegistration.setEndDate(courseRegistration.getEndDate());
            courseRegistrationRepository.save(_courseRegistration);
        }
        return new ResponseEntity<>("Course Registration has been updated",HttpStatus.OK);
    }

    public CourseRegistration findCourseRegistrationById(int id){
        return courseRegistrationRepository.findById(id).get();
    }
}
