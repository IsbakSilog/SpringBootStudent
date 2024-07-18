package com.mynt.test_isbak.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.mynt.test_isbak.model.Student;
import com.mynt.test_isbak.repository.StudentRepository;
import com.mynt.test_isbak.service.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TestStudent {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        // Arrange
        Student student = new Student(1L, "John Doe", "john@example.com");
        when(studentRepository.findAll()).thenReturn(Collections.singletonList(student));

        // Act
        List<Student> students = studentService.getAllStudent();

        // Assert
        assertEquals(1, students.size());
        assertEquals("John Doe", students.get(0).getName());
        verify(studentRepository, times(1)).findAll(); // Ensure the repository method was called once
    }

    @Test
    public void testSaveStudent() {
        // Arrange
        Student student = new Student(2L, "Jane Doe", "jane@example.com");
        when(studentRepository.save(any(Student.class))).thenReturn(student);

        // Act
        Student createdStudent = studentService.saveStudent(student);

        // Assert
        assertNotNull(createdStudent);
        assertEquals("Jane Doe", createdStudent.getName());
        verify(studentRepository, times(1)).save(any(Student.class)); // Ensure the repository method was called once
    }

    @Test
    public void testDeleteStudent() {
        // Arrange
        Long studentId = 1L;
        doNothing().when(studentRepository).deleteById(studentId);

        // Act
        studentService.deleteStudent(studentId);

        // Assert
        verify(studentRepository, times(1)).deleteById(studentId); // Ensure the repository method was called once
    }

}
