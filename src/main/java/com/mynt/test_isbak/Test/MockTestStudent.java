package com.mynt.test_isbak.Test;

import java.util.Arrays;
import java.util.List;

import com.mynt.test_isbak.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.mynt.test_isbak.repository.StudentRepository;
import com.mynt.test_isbak.service.StudentServiceImpl;

//import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class MockTestStudent {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllStudents() {
        Student student = new Student(1L, "John Doe", "john@example.com");
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student));

        List<Student> students = studentService.getAllStudent();
        assertEquals(1, students.size());
        assertEquals("John Doe", students.get(0).getName());
    }

    @Test
    public void testSaveStudent() {
        Student student = new Student(2L, "Jane Doe", "jane@example.com");
        when(studentRepository.save(student)).thenReturn(student);

        Student createdStudent = studentService.saveStudent(student);
        assertNotNull(createdStudent);
        assertEquals("Jane Doe", createdStudent.getName());
    }

    @Test
    public void testDeleteStudent() {
        Long studentId = 1L;
        doNothing().when(studentRepository).deleteById(studentId);

        studentService.deleteStudent(studentId);

        verify(studentRepository, times(1)).deleteById(studentId);
    }
}