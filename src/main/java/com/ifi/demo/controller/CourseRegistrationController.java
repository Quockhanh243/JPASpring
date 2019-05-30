package com.ifi.demo.controller;

import com.ifi.demo.entity.CourseRegistration;
import com.ifi.demo.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/courseRegs")
public class CourseRegistrationController {

    @Autowired
    CourseRegistrationService courseRegistrationService;

    @GetMapping("")
    public Set<CourseRegistration> getCourse(){
        return courseRegistrationService.getAll();
    }

    @PostMapping("/create")
    public CourseRegistration createCourseRegs(@RequestBody CourseRegistration courseRegistration){
        System.out.println(courseRegistration.getCourse().getName());
        return courseRegistrationService.CreateCourseRegistration(courseRegistration);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delCourseRegistration(@PathVariable("id")int id){
        return courseRegistrationService.deleteCourseRegistration(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id, @RequestBody CourseRegistration courseRegistration){
        return courseRegistrationService.updateCourseRegistration(id, courseRegistration);
    }

    @GetMapping("/{id}")
    public CourseRegistration findbyId(@PathVariable("id") int id){
        return courseRegistrationService.findCourseRegistrationById(id);
    }
}
