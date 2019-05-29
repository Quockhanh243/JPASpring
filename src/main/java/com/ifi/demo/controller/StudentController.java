package com.ifi.demo.controller;

import com.ifi.demo.entity.Student;
import com.ifi.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("")
    public Set<Student> getStudent(){
        return studentService.getAll();
    }

    @PostMapping(value = "/create")
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getName());
        return studentService.createStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id")int id){
        return studentService.deleteStudent(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") int id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @GetMapping("/{id}")
    public Student findbyId(@PathVariable("id") int id){
        return studentService.findStudentById(id);
    }
}
