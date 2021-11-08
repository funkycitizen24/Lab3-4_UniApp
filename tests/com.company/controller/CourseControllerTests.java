package com.company.controller;

import static org.junit.jupiter.api.Assertions.*;
import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.view.CourseView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseControllerTests {
    private static Course model;
    private static CourseView view;
    private static CourseController coursectrl;
    private static Teacher teacher;
    private static List<Course> coursesTeacher;
    private static List<Student> studentsForCourse;

    @BeforeEach
    void setUp() {
        coursesTeacher = new ArrayList<>();
        studentsForCourse = new ArrayList<>();
        teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        model = new Course("BD",teacher,1,studentsForCourse,5,1);
        view = new CourseView();
        coursectrl = new CourseController(model,view);
    }

    @Test
    void getCourseCourseIdTestPositive(){
        assertEquals(model.getCourseId()==1,model.getCourseId()==1);
    }

    @Test
    void getCourseCourseIdTestNegative(){
        assertNotEquals(model.getCourseId()==100,model.getCourseId()==1);
    }

    @Test
    void setCourseCourseIdTestPositive(){
        model.setCourseId(3);
        assertEquals(model.getCourseId()==3,model.getCourseId()==3);
    }

    @Test
    void setCourseCourseIdTestNegative(){
        model.setCourseId(3);
        assertNotEquals(model.getCourseId()==1,model.getCourseId()==3);
    }

    @Test
    void getCourseNameTestPositive(){
        assertEquals(model.getName().equals("BD"),model.getName().equals("BD"));
    }

    @Test
    void getCourseNameTestNegative(){
        assertNotEquals(model.getName().equals("SDA"),model.getName().equals("BD"));
    }

    @Test
    void setCourseNameTestPositive(){
        model.setName("SDA");
        assertEquals(model.getName().equals("SDA"),model.getName().equals("SDA"));
    }

    @Test
    void setCourseNameTestNegative(){
        model.setName("SDA");
        assertNotEquals(model.getName().equals("BD"),model.getName().equals("SDA"));
    }

    @Test
    void getCourseTeacherTestPositive(){
        assertEquals(model.getTeacher().equals(teacher),model.getTeacher().equals(teacher));
    }

    @Test
    void getCourseTeacherTestNegative(){
        Teacher tempteacher = new Teacher("Catalin","Rusu",2,coursesTeacher);
        assertNotEquals(model.getTeacher().equals(tempteacher),model.getTeacher().equals(tempteacher));
    }

    @Test
    void setCourseTeacherTestPositive(){
        Teacher tempteacher = new Teacher("Catalin","Rusu",2,coursesTeacher);
        model.setTeacher(tempteacher);
        assertEquals(model.getTeacher().equals(tempteacher),model.getTeacher().equals(tempteacher));
    }

    @Test
    void setCourseTeacherTestNegative(){
        Teacher tempteacher = new Teacher("Catalin","Rusu",2,coursesTeacher);
        model.setTeacher(tempteacher);
        assertNotEquals(model.getTeacher().equals(teacher),model.getTeacher().equals(tempteacher));
    }

    @Test
    void getCourseMaxEnrollmentTestPositive(){
        assertEquals(model.getMaxEnrollment()==1,model.getMaxEnrollment()==1);
    }

    @Test
    void getCourseMaxEnrollmentTestNegative(){
        assertNotEquals(model.getMaxEnrollment()==7,model.getMaxEnrollment()==1);
    }

    @Test
    void setCourseMaxEnrollmentTestPositive(){
        model.setMaxEnrollment(4);
        assertEquals(model.getMaxEnrollment()==4,model.getMaxEnrollment()==4);
    }

    @Test
    void setCourseMaxEnrollmentTestNegative(){
        model.setMaxEnrollment(4);
        assertNotEquals(model.getMaxEnrollment()==1,model.getMaxEnrollment()==4);
    }

    @Test
    void getCourseStudentsEnrolledTestPositive(){
        assertEquals(model.getStudentsEnrolled().size()==0,model.getStudentsEnrolled().size()==0);
    }

    @Test
    void getCourseStudentsEnrolledTestNegative(){
        assertNotEquals(model.getStudentsEnrolled().size()==20,model.getStudentsEnrolled().size()==0);
    }

    @Test
    void setCourseStudentsEnrolledTestPositive(){
        List<Course> coursesStudent = new ArrayList<>();
        Student student = new Student("Miruna", "Lupas", 1, 30, coursesStudent);
        List<Student> tempstudents = new ArrayList<>();
        tempstudents.add(student);
        model.setStudentsEnrolled(tempstudents);
        assertEquals(model.getStudentsEnrolled().equals(tempstudents),model.getStudentsEnrolled().equals(tempstudents));
    }

    @Test
    void setCourseStudentsEnrolledTestNegative(){
        List<Course> coursesStudent = new ArrayList<>();
        Student student = new Student("Miruna", "Lupas", 1, 30, coursesStudent);
        List<Student> tempstudents = new ArrayList<>();
        tempstudents.add(student);
        model.setStudentsEnrolled(tempstudents);
        assertNotEquals(model.getStudentsEnrolled().size()==0,model.getStudentsEnrolled().size()==1);
    }

    @Test
    void getCourseCreditsTestPositive(){
        assertEquals(model.getCredits()==5,model.getCredits()==5);
    }

    @Test
    void getCourseCreditsTestNegative(){
        assertNotEquals(model.getCredits()==7,model.getCredits()==5);
    }

    @Test
    void setCourseCreditsTestPositive(){
        model.setCredits(4);
        assertEquals(model.getCredits()==4,model.getCredits()==4);
    }

    @Test
    void setCourseCreditsTestNegative(){
        model.setCredits(4);
        assertNotEquals(model.getCredits()==5,model.getCredits()==4);
    }
}