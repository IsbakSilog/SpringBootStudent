package com.mynt.test_isbak.Test;

import java.util.*;
import com.mynt.test_isbak.model.Student;
import org.junit.jupiter.api.*;
import org.mockito.*;
import com.mynt.test_isbak.repository.StudentRepository;
import com.mynt.test_isbak.service.StudentServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
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
    public void testGetAll() {
        Student student = new Student(1L, "Ben Dover", "john@example.com");
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student));

        List<Student> students = studentService.getAllStudent();
        assertEquals(1, students.size());
        assertEquals("Ben Dover", students.get(0).getName());
    }

    @Test
    public void testSave() {
        Student student = new Student(2L, "Ben Dover", "jane@example.com");
        when(studentRepository.save(student)).thenReturn(student);

        Student createdStudent = studentService.saveStudent(student);
        assertNotNull(createdStudent);
        assertEquals("Ben Dover", createdStudent.getName());
    }

    @Test
    public void testDelete() {
        Long studentId = 1L;
        doNothing().when(studentRepository).deleteById(studentId);

        studentService.deleteStudent(studentId);

        verify(studentRepository, times(1)).deleteById(studentId);
    }
}