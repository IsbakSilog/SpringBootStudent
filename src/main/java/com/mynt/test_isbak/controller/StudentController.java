package com.mynt.test_isbak.controller;

import com.mynt.test_isbak.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mynt.test_isbak.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(id, student);
        if (updatedStudent != null) {
            return ResponseEntity.ok(updatedStudent);
        }
        return ResponseEntity.notFound().build();
    }

}




