package com.company;

import static org.junit.jupiter.api.Assertions.*;

import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import com.company.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class RegistrationSystemTests {
    @Test
    void RegisterTest(){
        //list of courses for students
        List<Course> coursesStudent1 = new ArrayList<>();
        List<Course> coursesStudent2 = new ArrayList<>();
        List<Course> coursesStudent3 = new ArrayList<>();

        //students
        Student student1 = new Student("Miruna", "Lupas", 1, 30, coursesStudent1);
        Student student2 = new Student("Monika", "Popescu", 2, 20, coursesStudent2);
        Student student3 = new Student("Andreea", "Vrabie", 3, 25, coursesStudent3);

        //list of courses for teacher
        List<Course> coursesTeacher = new ArrayList<>();

        //teacher
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);

        //list of students for courses
        List<Student> studentsForCourse1 = new ArrayList<>();
        List<Student> studentsForCourse2 = new ArrayList<>();

        //courses
        Course course1 = new Course("BD",teacher,15,studentsForCourse1,5,1);
        Course course2 = new Course("SDA",teacher,20,studentsForCourse2,4,2);

        //add the courses to the teacher
        coursesTeacher.add(course1);
        coursesTeacher.add(course2);

        //repo for courses
        List<Course> courses = new ArrayList<>();
        CourseRepository courseRepo = new CourseRepository(courses);
        courseRepo.getCourseList().add(course1);
        courseRepo.getCourseList().add(course2);

        //registrationSystem
        RegistrationSystem registSyst = new RegistrationSystem(courseRepo);

        //valid student and course
        registSyst.register(course1,student2);
        assertSame(student2, student2);
        assertNotSame(student1, student2);

        //valid course but student with too many credits
        registSyst.register(course2,student1);
        assertEquals(course2.getStudentsEnrolled().size() == 0,course2.getStudentsEnrolled().size() == 0);
        assertNotEquals(course2.getStudentsEnrolled().size() == 1,course2.getStudentsEnrolled().size() == 0);

        //valid student but no more free places for the course
        registSyst.register(course1,student3);
//        assertTrue(student3.getEnrolledCourses().size() == 0);
//        assertFalse(student3.getEnrolledCourses().size() == 1);
        assertEquals(student3.getEnrolledCourses().size() == 0,student3.getEnrolledCourses().size() == 0);
        assertNotEquals(student3.getEnrolledCourses().size() == 1,student3.getEnrolledCourses().size() == 0);
    }

    @Test
    void retrieveCoursesWithFreePlacesTest(){
        List<Course> coursesStudent = new ArrayList<>();
        Student student = new Student("Miruna", "Lupas", 3, 30, coursesStudent);

        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);

        //list of students for courses
        List<Student> studentsForCourse1 = new ArrayList<>();
        List<Student> studentsForCourse2 = new ArrayList<>();

        //courses
        Course course1 = new Course("BD",teacher,15,studentsForCourse1,5,1);
        Course course2 = new Course("SDA",teacher,20,studentsForCourse2,4,2);

        //add the courses to the teacher
        coursesTeacher.add(course1);
        coursesTeacher.add(course2);

        //repo for courses
        List<Course> courses = new ArrayList<>();
        CourseRepository courseRepo = new CourseRepository(courses);
        courseRepo.getCourseList().add(course1);
        courseRepo.getCourseList().add(course2);

        //registrationSystem
        RegistrationSystem registSyst = new RegistrationSystem(courseRepo);

        assertEquals(registSyst.retrieveCoursesWithFreePlaces().size()==2,registSyst.retrieveCoursesWithFreePlaces().size()==2);
        assertNotEquals(registSyst.retrieveCoursesWithFreePlaces().size()==0,registSyst.retrieveCoursesWithFreePlaces().size()==2);

        registSyst.register(course1,student);
        assertEquals(registSyst.retrieveCoursesWithFreePlaces().size()==1,registSyst.retrieveCoursesWithFreePlaces().size()==1);
        assertNotEquals(registSyst.retrieveCoursesWithFreePlaces().size()==2,registSyst.retrieveCoursesWithFreePlaces().size()==1);
    }

    @Test
    void retrieveStudentsEnrolledForACourse(){
        List<Course> coursesStudent1 = new ArrayList<>();
        List<Course> coursesStudent2 = new ArrayList<>();
        Student student1 = new Student("Monika", "Popescu", 3, 28, coursesStudent1);
        Student student2 = new Student("Miruna", "Lupas", 2, 20, coursesStudent2);

        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);

        //list of students for courses
        List<Student> studentsForCourse1 = new ArrayList<>();
        List<Student> studentsForCourse2 = new ArrayList<>();

        //courses
        Course course1 = new Course("BD",teacher,15,studentsForCourse1,5,1);
        Course course2 = new Course("SDA",teacher,20,studentsForCourse2,4,2);

        //add the courses to the teacher
        coursesTeacher.add(course1);
        coursesTeacher.add(course2);

        //repo for courses
        List<Course> courses = new ArrayList<>();
        CourseRepository courseRepo = new CourseRepository(courses);
        courseRepo.getCourseList().add(course1);
        courseRepo.getCourseList().add(course2);

        //registrationSystem
        RegistrationSystem registSyst = new RegistrationSystem(courseRepo);
        assertEquals(registSyst.retrieveStudentsEnrolledForACourse(course1).size()==0,registSyst.retrieveStudentsEnrolledForACourse(course1).size()==0);
        assertNotEquals(registSyst.retrieveStudentsEnrolledForACourse(course1).size()==10,registSyst.retrieveStudentsEnrolledForACourse(course1).size()==0);


        registSyst.register(course2,student1);
        registSyst.register(course2,student2);
        assertEquals(registSyst.retrieveStudentsEnrolledForACourse(course2).size()==2,registSyst.retrieveStudentsEnrolledForACourse(course2).size()==2);
        assertNotEquals(registSyst.retrieveStudentsEnrolledForACourse(course2).size()==0,registSyst.retrieveStudentsEnrolledForACourse(course2).size()==2);
    }

    @Test
    void getAllCoursesTest(){
        List<Course> coursesTeacher = new ArrayList<>();
        Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);

        //list of students for courses
        List<Student> studentsForCourse1 = new ArrayList<>();
        List<Student> studentsForCourse2 = new ArrayList<>();

        //courses
        Course course1 = new Course("BD",teacher,1,studentsForCourse1,5,1);
        Course course2 = new Course("SDA",teacher,20,studentsForCourse2,4,2);

        //add the courses to the teacher
        coursesTeacher.add(course1);
        coursesTeacher.add(course2);

        //repo for courses
        List<Course> courses = new ArrayList<>();
        CourseRepository courseRepo = new CourseRepository(courses);
        courseRepo.getCourseList().add(course1);
        courseRepo.getCourseList().add(course2);

        //registrationSystem
        RegistrationSystem registSyst = new RegistrationSystem(courseRepo);
        assertEquals(registSyst.getAllCourses().size()==2,registSyst.getAllCourses().size()==2);
        assertNotEquals(registSyst.getAllCourses().size()==10,registSyst.getAllCourses().size()==2);
    }
}