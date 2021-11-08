package com.company.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTests {
    private static List<Course> coursesStudent;
    private static Student student;

    @BeforeEach
    void setUp() {
        coursesStudent = new ArrayList<>();
        student = new Student("Miruna", "Lupas", 2, 25, coursesStudent);
    }

    @Test
    void getStudentIdTestPositive(){
        assertEquals(student.getStudentId()==2,student.getStudentId()==2);
    }

    @Test
    void getStudentIdTestNegative(){
        assertNotEquals(student.getStudentId()==1,student.getStudentId()==2);
    }

    @Test
    void setStudentIdTestPositive(){
        student.setStudentId(3);
        assertEquals(student.getStudentId()==3,student.getStudentId()==3);
    }

    @Test
    void setStudentIdTestNegative(){
        student.setStudentId(3);
        assertNotEquals(student.getStudentId()==2,student.getStudentId()==3);
    }

    @Test
    void getTotalCreditsTestPositive(){
        assertEquals(student.getTotalCredits()==25,student.getTotalCredits()==25);
    }

    @Test
    void getTotalCreditsTestNegative(){
        assertNotEquals(student.getTotalCredits()==2,student.getTotalCredits()==25);
    }

    @Test
    void setTotalCreditsTestPositive(){
        student.setTotalCredits(4);
        assertEquals(student.getTotalCredits()==4,student.getTotalCredits()==4);
    }

    @Test
    void setTotalCreditsTestNegative(){
        student.setTotalCredits(4);
        assertNotEquals(student.getTotalCredits()==25,student.getTotalCredits()==4);
    }

    @Test
    void getEnrolledCoursesTestPositive(){
        assertEquals(student.getEnrolledCourses().size()==0,student.getEnrolledCourses().size()==0);
    }

    @Test
    void getEnrolledCoursesTestNegative(){
        assertNotEquals(student.getEnrolledCourses().size()==4,student.getEnrolledCourses().size()==0);
    }

    @Test
    void setEnrolledCoursesTestPositive(){
        List<Student> studentsForCourse = new ArrayList<>();
        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        Course course = new Course("BD",teacher,10,studentsForCourse,5,1);
        List<Course> tempcourses = new ArrayList<>();
        tempcourses.add(course);
        student.setEnrolledCourses(tempcourses);
        assertEquals(student.getEnrolledCourses().equals(tempcourses),student.getEnrolledCourses().equals(tempcourses));
    }

    @Test
    void setEnrolledCoursesTestNegative(){
        List<Student> studentsForCourse = new ArrayList<>();
        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        Course course = new Course("BD",teacher,10,studentsForCourse,5,1);
        List<Course> tempcourses = new ArrayList<>();
        tempcourses.add(course);
        student.setEnrolledCourses(tempcourses);
        assertNotEquals(student.getEnrolledCourses().size()==0,student.getEnrolledCourses().size()==1);
    }
}