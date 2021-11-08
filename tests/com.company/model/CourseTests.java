package com.company.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class CourseTests {
    private static List<Course> coursesTeacher;
    private static Teacher teacher;
    private static List<Student> studentsForCourse;
    private static Course course;

    @BeforeEach
    void setUp() {
        coursesTeacher = new ArrayList<>();
        studentsForCourse = new ArrayList<>();
        teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
        course = new Course("BD",teacher,1,studentsForCourse,5,1);
        coursesTeacher.add(course);
    }

    @Test
    void getCourseIdTestPositive(){
        assertEquals(course.getCourseId()==1,course.getCourseId()==1);
    }

    @Test
    void getCourseIdTestNegative(){
        assertNotEquals(course.getCourseId()==100,course.getCourseId()==1);
    }

    @Test
    void setCourseIdTestPositive(){
        course.setCourseId(3);
        assertEquals(course.getCourseId()==3,course.getCourseId()==3);
    }

    @Test
    void setCourseIdTestNegative(){
        course.setCourseId(3);
        assertNotEquals(course.getCourseId()==1,course.getCourseId()==3);
    }

    @Test
    void getNameTestPositive(){
        assertEquals(course.getName().equals("BD"),course.getName().equals("BD"));
    }

    @Test
    void getNameTestNegative(){
        assertNotEquals(course.getName().equals("SDA"),course.getName().equals("BD"));
    }

    @Test
    void setNameTestPositive(){
        course.setName("SDA");
        assertEquals(course.getName().equals("SDA"),course.getName().equals("SDA"));
    }

    @Test
    void setNameTestNegative(){
        course.setName("SDA");
        assertNotEquals(course.getName().equals("BD"),course.getName().equals("SDA"));
    }

    @Test
    void getTeacherTestPositive(){
        assertEquals(course.getTeacher().equals(teacher),course.getTeacher().equals(teacher));
    }

    @Test
    void getTeacherTestNegative(){
        Teacher tempteacher = new Teacher("Catalin","Rusu",2,coursesTeacher);
        assertNotEquals(course.getTeacher().equals(tempteacher),course.getTeacher().equals(teacher));
    }

    @Test
    void setTeacherTestPositive(){
        Teacher tempteacher = new Teacher("Catalin","Rusu",2,coursesTeacher);
        course.setTeacher(tempteacher);
        assertEquals(course.getTeacher().equals(tempteacher),course.getTeacher().equals(tempteacher));
    }

    @Test
    void setTeacherTestNegative(){
        Teacher tempteacher = new Teacher("Catalin","Rusu",2,coursesTeacher);
        course.setTeacher(tempteacher);
        assertNotEquals(course.getTeacher().equals(teacher),course.getTeacher().equals(tempteacher));
    }

    @Test
    void getMaxEnrollmentTestPositive(){
        assertEquals(course.getMaxEnrollment()==1,course.getMaxEnrollment()==1);
    }

    @Test
    void getMaxEnrollmentTestNegative(){
        assertNotEquals(course.getMaxEnrollment()==7,course.getMaxEnrollment()==1);
    }

    @Test
    void setMaxEnrollmentTestPositive(){
        course.setMaxEnrollment(4);
        assertEquals(course.getMaxEnrollment()==4,course.getMaxEnrollment()==4);
    }

    @Test
    void setMaxEnrollmentTestNegative(){
        course.setMaxEnrollment(4);
        assertNotEquals(course.getMaxEnrollment()==1,course.getMaxEnrollment()==4);
    }

    @Test
    void getStudentsEnrolledTestPositive(){
        assertEquals(course.getStudentsEnrolled().size()==0,course.getStudentsEnrolled().size()==0);
    }

    @Test
    void getStudentsEnrolledTestNegative(){
        assertNotEquals(course.getStudentsEnrolled().size()==20,course.getStudentsEnrolled().size()==0);
    }

    @Test
    void setStudentsEnrolledTestPositive(){
        List<Course> coursesStudent = new ArrayList<>();
        Student student = new Student("Monika", "Popescu", 1, 30, coursesStudent);
        List<Student> tempstudents = new ArrayList<>();
        tempstudents.add(student);
        course.setStudentsEnrolled(tempstudents);
        assertEquals(course.getStudentsEnrolled().equals(tempstudents),course.getStudentsEnrolled().equals(tempstudents));
    }

    @Test
    void setStudentsEnrolledTestNegative(){
        List<Course> coursesStudent = new ArrayList<>();
        Student student = new Student("Monika", "Popescu", 1, 30, coursesStudent);
        List<Student> tempstudents = new ArrayList<>();
        tempstudents.add(student);
        course.setStudentsEnrolled(tempstudents);
        assertNotEquals(course.getStudentsEnrolled().size()==0, course.getStudentsEnrolled().size() ==1 );
    }

    @Test
    void getCreditsTestPositive(){
        assertEquals(course.getCredits()==5,course.getCredits()==5);
    }

    @Test
    void getCreditsTestNegative(){
        assertNotEquals(course.getCredits()==7,course.getCredits()==5);
    }

    @Test
    void setCreditsTestPositive(){
        course.setCredits(4);
        assertEquals(course.getCredits()==4,course.getCredits()==4);
    }

    @Test
    void setCreditsTestNegative(){
        course.setCredits(4);
        assertNotEquals(course.getCredits()==5,course.getCredits()==4);
    }

}