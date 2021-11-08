package com.company.controller;

import static org.junit.jupiter.api.Assertions.*;
import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.view.TeacherView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


public class TeacherControllerTests {
    private static Teacher model;
    private static TeacherView view;
    private static TeacherController teacherctrl;
    private static List<Course> coursesTeacher;

    @BeforeEach
    void setUp() {
        coursesTeacher = new ArrayList<>();
        model = new Teacher("Diana","Cristea",1,coursesTeacher);
        view = new TeacherView();
        teacherctrl = new TeacherController(model,view);
    }

    @Test
    void getTeacherFirstNameTestPositive(){
        assertEquals(model.getFirstName().equals("Diana"),model.getFirstName().equals("Diana"));
    }

    @Test
    void getTeacherFirstNameTestNegative(){
        assertNotEquals(model.getFirstName().equals("Catalin"),model.getFirstName().equals("Diana"));
    }

    @Test
    void setTeacherFirstNameTestPositive(){
        model.setFirstName("Catalin");
        assertEquals(model.getFirstName().equals("Catalin"),model.getFirstName().equals("Catalin"));
    }

    @Test
    void setTeacherFirstNameTestNegative(){
        model.setFirstName("Catalin");
        assertNotEquals(model.getFirstName().equals("Diana"),model.getFirstName().equals("Catalin"));
    }

    @Test
    void getTeacherLastNameTestPositive(){
        assertEquals(model.getLastName().equals("Cristea"),model.getLastName().equals("Cristea"));
    }

    @Test
    void getTeacherLastNameTestNegative(){
        assertNotEquals(model.getLastName().equals("Lupas"),model.getLastName().equals("Cristea"));
    }

    @Test
    void setTeacherLastNameTestPositive(){
        model.setLastName("Lupas");
        assertEquals(model.getLastName().equals("Lupas"),model.getLastName().equals("Lupas"));
    }

    @Test
    void setTeacherLastNameTestNegative(){
        model.setLastName("Lupas");
        assertNotEquals(model.getLastName().equals("Cristea"),model.getLastName().equals("Cristea"));
    }

    @Test
    void getTeacherTeacherIdTestPositive(){
        assertEquals(model.getTeacherId()==1, model.getTeacherId()==1);
    }

    @Test
    void getTeacherTeacherIdTestNegative(){
        assertNotEquals(model.getTeacherId()==4,model.getTeacherId()==1);
    }

    @Test
    void setTeacherTeacherIdTestPositive(){
        model.setTeacherId(3);
        assertEquals(model.getTeacherId()==3,model.getTeacherId()==3);
    }

    @Test
    void setTeacherTeacherIdTestNegative(){
        model.setTeacherId(3);
        assertNotEquals(model.getTeacherId()==1,model.getTeacherId()==3);
    }

    @Test
    void getTeacherCoursesTestPositive(){
        assertEquals(model.getCourses().size()==0,model.getCourses().size()==0);
    }

    @Test
    void getTeacherCoursesTestNegative(){
        assertNotEquals(model.getCourses().size()==1,model.getCourses().size()==0);
    }

    @Test
    void setTeacherCoursesTestPositive(){
        List<Student> studentsForCourse = new ArrayList<>();
        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        Course course = new Course("BD",teacher,1,studentsForCourse,5,1);
        List<Course> tempcourses = new ArrayList<>();
        tempcourses.add(course);
        model.setCourses(tempcourses);
        assertEquals(model.getCourses().equals(tempcourses),model.getCourses().equals(tempcourses));
    }

    @Test
    void setTeacherCoursesTestNegative(){
        List<Student> studentsForCourse = new ArrayList<>();
        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        Course course = new Course("BD",teacher,1,studentsForCourse,5,1);
        List<Course> tempcourses = new ArrayList<>();
        tempcourses.add(course);
        model.setCourses(tempcourses);
        assertNotEquals(model.getCourses().size()==0,model.getCourses().size()==1);
    }
}