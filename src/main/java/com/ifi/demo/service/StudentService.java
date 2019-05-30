package com.ifi.demo.service;

import com.ifi.demo.entity.Student;
import com.ifi.demo.repository.StudentRepository;
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
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Set<Student> getAll(){
        System.out.println("Get all student ...");
        Set<Student> students = new HashSet<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student createStudent(Student student){
        Student _student = studentRepository.save(new Student(student.getName(),student.getBirth()));
        System.out.println("Student has been Created....");
        return _student;
    }

    public ResponseEntity<String> deleteStudent(int id){
        System.out.println("Delete Student with ID = " + id + "...");

        studentRepository.deleteById(id);

        return new ResponseEntity<>("Student has been deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> updateStudent(int id, Student student){
        System.out.println("Update Student with ID= "+id+".......");

        Optional<Student> studentData = studentRepository.findById(id);

        if(studentData.isPresent()){
            Student _student = studentData.get();
            if(student.getName()!=null)
            {
                System.out.println(student.getName());
                _student.setName(student.getName());
            }
            if (student.getBirth()!=null)
            {
                _student.setBirth(student.getBirth());
            }
            studentRepository.save(_student);
        }

        return new ResponseEntity<>("Student has been updated",HttpStatus.OK);
    }

    public Student findStudentById(int id){
        return studentRepository.findById(id).get();
    }
}
