package com.mynt.test_isbak.service;

import com.mynt.test_isbak.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mynt.test_isbak.repository.StudentRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.Array;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> students = new ArrayList<Student>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;}


//    @Override
//    public List<Student> findByAgeGreaterThan(int age) {
//    return studentRepository.findByAgeGreaterThan(age);
//    }

    @Override
    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @Override
    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student deleted with id: " + id;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudentOpt = studentRepository.findById(id);
        if (existingStudentOpt.isPresent()) {
            Student existingStudent = existingStudentOpt.get();

            // Set the fields that need to be updated
            if (student.getName() != null) {
                existingStudent.setName(student.getName());
            }
            if (student.getId() != null) {
                existingStudent.setId(student.getId());
            }
            if (student.getEmail() != null) {
                existingStudent.setEmail(student.getEmail());
            }
            // Add other fields as needed

            Student updatedStudent = studentRepository.save(existingStudent);
            System.out.println("Updated student: " + updatedStudent);
            return updatedStudent;
        } else {
            System.out.println("Student with id " + id + " does not exist.");
            return null;
        }
    }

}




