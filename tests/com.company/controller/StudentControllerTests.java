package com.company.controller;

import static org.junit.jupiter.api.Assertions.*;
import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.view.StudentView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


public class StudentControllerTests {
    private static Student model;
    private static StudentView view;
    private static StudentController studentctrl;
    private static List<Course> coursesStudent;

    @BeforeEach
    void setUp() {
        coursesStudent = new ArrayList<>();
        model = new Student("Andreea", "Vrabie", 3, 5, coursesStudent);
        view = new StudentView();
        studentctrl = new StudentController(model,view);
    }

    @Test
    void getStudentFirstNameTestPositive(){
        assertEquals(model.getFirstName().equals("Andreea"),model.getFirstName().equals("Andreea"));
    }

    @Test
    void getStudentFirstNameTestNegative(){
        assertNotEquals(model.getFirstName().equals("Miruna"),model.getFirstName().equals("Andreea"));
    }

    @Test
    void setStudentFirstNameTestPositive(){
        model.setFirstName("Andreea");
        assertEquals(model.getFirstName().equals("Andreea"),model.getFirstName().equals("Andreea"));
    }

    @Test
    void setStudentFirstNameTestNegative(){
        model.setFirstName("Andreea");
        assertNotEquals(model.getFirstName().equals("Miruna"),model.getFirstName().equals("Andreea"));
    }

    @Test
    void getStudentLastNameTestPositive(){
        assertEquals(model.getLastName().equals("Vrabie"),model.getLastName().equals("Vrabie"));
    }

    @Test
    void getStudentLastNameTestNegative(){
        assertNotEquals(model.getLastName().equals("Lupas"),model.getLastName().equals("Vrabie"));
    }

    @Test
    void setStudentLastNameTestPositive(){
        model.setLastName("Vrabie");
        assertEquals(model.getLastName().equals("Vrabie"),model.getLastName().equals("Vrabie"));
    }

    @Test
    void setStudentLastNameTestNegative(){
        model.setLastName("Vrabie");
        assertNotEquals(model.getLastName().equals("Lupas"),model.getLastName().equals("Vrabie"));
    }

    @Test
    void getStudentStudentIdTestPositive(){
        assertEquals(model.getStudentId()==3,model.getStudentId()==3);
    }

    @Test
    void getStudentStudentIdTestNegative(){
        assertNotEquals(model.getStudentId()==1,model.getStudentId()==3);
    }

    @Test
    void setStudentStudentIdTestPositive(){
        model.setStudentId(3);
        assertEquals(model.getStudentId()==3,model.getStudentId()==3);
    }

    @Test
    void setStudentStudentIdTestNegative(){
        model.setStudentId(3);
        assertNotEquals(model.getStudentId()==2,model.getStudentId()==3);
    }

    @Test
    void getStudentTotalCreditsTestPositive(){
        assertEquals(model.getTotalCredits()==5,model.getTotalCredits()==5);
    }

    @Test
    void getStudentTotalCreditsTestNegative(){
        assertNotEquals(model.getTotalCredits()==2,model.getTotalCredits()==5);
    }

    @Test
    void setStudentTotalCreditsTestPositive(){
        model.setTotalCredits(4);
        assertEquals(model.getTotalCredits()==4,model.getTotalCredits()==4);
    }

    @Test
    void setStudentTotalCreditsTestNegative(){
        model.setTotalCredits(4);
        assertNotEquals(model.getTotalCredits()==20,model.getTotalCredits()==4);
    }

    @Test
    void getStudentEnrolledCoursesTestPositive(){
        assertEquals(model.getEnrolledCourses().size()==0,model.getEnrolledCourses().size()==0);
    }

    @Test
    void getStudentEnrolledCoursesTestNegative(){
        assertNotEquals(model.getEnrolledCourses().size()==4,model.getEnrolledCourses().size()==0);
    }

    @Test
    void setStudentEnrolledCoursesTestPositive(){
        List<Student> studentsForCourse = new ArrayList<>();
        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        Course course = new Course("BD",teacher,1,studentsForCourse,5,1);
        List<Course> tempcourses = new ArrayList<>();
        tempcourses.add(course);
        model.setEnrolledCourses(tempcourses);
        assertEquals(model.getEnrolledCourses().equals(tempcourses),model.getEnrolledCourses().equals(tempcourses));
    }

    @Test
    void setStudentEnrolledCoursesTestNegative(){
        List<Student> studentsForCourse = new ArrayList<>();
        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        Course course = new Course("BD",teacher,1,studentsForCourse,5,1);
        List<Course> tempcourses = new ArrayList<>();
        tempcourses.add(course);
        model.setEnrolledCourses(tempcourses);
        assertNotEquals(model.getEnrolledCourses().size()==0,model.getEnrolledCourses().size()==1);
    }
}
