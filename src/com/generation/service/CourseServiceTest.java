package com.generation.service;

import com.generation.model.Course;
import com.generation.model.Module;
import com.generation.model.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CourseServiceTest {
    private CourseService courseService;

    @Before
    public void setUp() {
        courseService = new CourseService();
    }

    @Test
    public void testRegisterCourse() {
        Module testModule = new Module("TEST-MODULE", "Test Module", "This is a test module");
        Course testCourse = new Course("TEST-COURSE", "Test Course", 9, testModule);

        // Register the test course
        courseService.registerCourse(testCourse);

        // Check if the course was registered successfully
        Course registeredCourse = courseService.getCourse("TEST-COURSE");
        assertNotNull(registeredCourse);
        assertEquals(testCourse, registeredCourse);
    }

    @Test
    public void testGetCourse() {
        // Get a course that exists in the CourseService
        Course existingCourse = courseService.getCourse("INTRO-CS-1");
        assertNotNull(existingCourse);
        assertEquals("Introduction to Computer Science", existingCourse.getName());

        // Get a course that doesn't exist in the CourseService
        Course nonExistingCourse = courseService.getCourse("NON-EXISTING-COURSE");
        assertNull(nonExistingCourse);
    }
}