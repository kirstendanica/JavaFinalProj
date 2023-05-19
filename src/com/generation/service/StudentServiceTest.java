package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class StudentServiceTest {
    private StudentService studentService;

    @Before
    public void setUp() {
        studentService = new StudentService();
    }

    @Test
    public void testSubscribeStudent() {
        // Given
        Student student = new Student("1", "Massyl L", "MassylL@gmail.com", "02/04/1990" );

        // When
        studentService.subscribeStudent(student);

        // Then
        Student foundStudent = studentService.findStudent("1");
        assertEquals(student, foundStudent);
    }

    @Test
    public void testFindStudent() {
        // Given
        Student student2 = new Student("1", "Massyl L", "MassylL@gmail.com", "02/04/1990" );
        Student student1 = new Student("2", "Masha M", "MashaM@gmail.com", "06/04/1995" );
        studentService.subscribeStudent(student1);
        studentService.subscribeStudent(student2);

        // When
        Student foundStudent1 = studentService.findStudent("1");
        Student foundStudent2 = studentService.findStudent("2");
        Student notFoundStudent = studentService.findStudent("3");

        // Then
        assertEquals(student1, foundStudent1);
        assertEquals(student2, foundStudent2);
        assertNull(notFoundStudent);
    }
}