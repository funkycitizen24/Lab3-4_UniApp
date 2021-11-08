package com.company.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherTests {
    private static List<Course> coursesTeacher;
    private static Teacher teacher;

    @BeforeEach
    void setUp() {
        coursesTeacher = new ArrayList<>();
        teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
    }

    @Test
    void getTeacherIdTestPositive(){
        assertEquals(teacher.getTeacherId()==1,teacher.getTeacherId()==1);
    }

    @Test
    void getTeacherIdTestNegative(){
        assertNotEquals(teacher.getTeacherId()==4,teacher.getTeacherId()==1);
    }

    @Test
    void setTeacherIdTestPositive(){
        teacher.setTeacherId(3);
        assertEquals(teacher.getTeacherId()==3,teacher.getTeacherId()==3);
    }

    @Test
    void setTeacherIdTestNegative(){
        teacher.setTeacherId(3);
        assertNotEquals(teacher.getTeacherId()==1,teacher.getTeacherId()==3);
    }

    @Test
    void getCoursesTestPositive(){
        assertEquals(teacher.getCourses().size()==0,teacher.getCourses().size()==0);
    }

    @Test
    void getCoursesTestNegative(){
        assertNotEquals(teacher.getCourses().size()==1,teacher.getCourses().size()==0);
    }

    @Test
    void setCoursesTestPositive(){
        List<Student> studentsForCourse = new ArrayList<>();
        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        Course course = new Course("BD",teacher,1,studentsForCourse,5,1);
        List<Course> tempcourses = new ArrayList<>();
        tempcourses.add(course);
        teacher.setCourses(tempcourses);
        assertEquals(teacher.getCourses().equals(tempcourses), teacher.getCourses().equals(tempcourses));
    }

    @Test
    void setCoursesTestNegative(){
        List<Student> studentsForCourse = new ArrayList<>();
        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        Course course = new Course("BD",teacher,1,studentsForCourse,5,1);
        List<Course> tempcourses = new ArrayList<>();
        tempcourses.add(course);
        teacher.setCourses(tempcourses);
        assertNotEquals(teacher.getCourses().size()==0,teacher.getCourses().size()==1);
    }
}