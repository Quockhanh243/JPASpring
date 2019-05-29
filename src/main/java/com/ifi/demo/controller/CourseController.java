package com.ifi.demo.controller;

import com.ifi.demo.entity.Course;
import com.ifi.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping("")
    public Set<Course> getCourse(){
        return courseService.getAll();
    }

    @PostMapping("/create")
    public Course createCourse(@RequestBody Course course){
        return courseService.createCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable("id")int id){
        return courseService.deleteCourse(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateCourse(@PathVariable("id") int id, @RequestBody Course course){
        return courseService.updateCourse(id, course);
    }

    @GetMapping("/{id}")
    public Course findbyId(@PathVariable("id") int id){
        return courseService.findCourseById(id);
    }
}
