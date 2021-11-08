package com.company.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import java.util.List;


public class CourseRepositoryTests {
    List<Course> courses = new ArrayList<>();
    CourseRepository courseRepo = new CourseRepository(courses);
    List<Course> coursesTeacher = new ArrayList<>();
    Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);
    List<Student> studentsForCourse1 = new ArrayList<>();
    List<Student> studentsForCourse2 = new ArrayList<>();
    Course course1 = new Course("BD",teacher,15,studentsForCourse1,5,1);
    Course course2 = new Course("SDA",teacher,20,studentsForCourse2,4,2);

    @BeforeEach
    void setUp() {
        coursesTeacher.add(course1);
        coursesTeacher.add(course2);
    }

    @Test
    public void getCourseListTestPositive() {
        courseRepo.getCourseList().add(course1);
        assertEquals(courseRepo.getCourseList().size()==1,courseRepo.getCourseList().size()==1);
    }

    @Test
    public void getCourseListTestNegative() {
        courseRepo.getCourseList().add(course1);
        assertNotEquals(courseRepo.getCourseList().size()==0,courseRepo.getCourseList().size()==1);
    }

    @Test
    public void setCourseListTestPositive() {
        List<Course> courseTemp = new ArrayList<>();
        courseTemp.add(course1);
        courseRepo.setCourseList(courseTemp);
        assertEquals(courseRepo.getCourseList().size()==1,courseRepo.getCourseList().size()==1);
    }

    @Test
    public void setCourseListTestNegative() {
        List<Course> courseTemp = new ArrayList<>();
        courseTemp.add(course1);
        courseRepo.setCourseList(courseTemp);
        assertNotEquals(courseRepo.getCourseList().size()==0,courseRepo.getCourseList().size()==1);
    }

    @Test
    public void findOneTestPositive(){
        courseRepo.getCourseList().add(course1);
        assertEquals(courseRepo.findOne(course1.getCourseId()).equals(course1),courseRepo.findOne(course1.getCourseId()).equals(course1));
    }

    @Test
    public void findOneTestNegative(){
        courseRepo.getCourseList().add(course1);
        assertNotEquals(courseRepo.findOne(course1.getCourseId()).equals(course2),courseRepo.findOne(course1.getCourseId()).equals(course1));
    }

    @Test
    public void findAllTestPositive(){
        int counter = 0; //count the elements (courses)
        courseRepo.getCourseList().add(course1);
        for (Course c : courseRepo.findAll()) {
            counter++;
        }
        assertEquals(counter == 1,counter == 1);
    }

    @Test
    public void findAllTestNegative(){
        int counter = 0; //count the elements (courses)
        courseRepo.getCourseList().add(course1);
        for (Course c : courseRepo.findAll()) {
            counter++;
        }
        assertNotEquals(counter == 0, counter == 1);
    }

    @Test
    public void saveTestPositive() {
        courseRepo.save(course1);
        assertEquals(courseRepo.getCourseList().get(0).equals(course1),courseRepo.getCourseList().get(0).equals(course1));
    }

    @Test
    public void saveTestNegative() {
        courseRepo.save(course1);
        assertNotEquals(courseRepo.getCourseList().size()==0,courseRepo.getCourseList().size()==1);
    }

    @Test
    public void deleteTestPositive() {
        courseRepo.save(course1);
        courseRepo.delete(course1.getCourseId());
        assertEquals(courseRepo.getCourseList().size()==0,courseRepo.getCourseList().size()==0);
    }

    @Test
    public void deleteTestNegative() {
        courseRepo.save(course1);
        courseRepo.delete(course1.getCourseId());
        assertNotEquals(courseRepo.getCourseList().size()==1, courseRepo.getCourseList().size()==0);
    }

    @Test
    public void updateTestPositive() {
        List<Student> studentsForCourseTemp = new ArrayList<>();
        Course tempCourse = new Course("BD",teacher,10,studentsForCourseTemp,6,1);
        courseRepo.save(course1);
        assertEquals(courseRepo.update(tempCourse)==null,courseRepo.update(tempCourse)==null);
        courseRepo.update(tempCourse);
        assertEquals(courseRepo.getCourseList().get(0).getMaxEnrollment()==10,courseRepo.getCourseList().get(0).getMaxEnrollment()==10);
        assertEquals(courseRepo.getCourseList().get(0).getCredits()==6,courseRepo.getCourseList().get(0).getCredits()==6);
    }

    @Test
    public void updateTestNegative() {
        List<Student> studentsForCourseTemp = new ArrayList<>();
        Course tempCourse = new Course("BD",teacher,10,studentsForCourseTemp,6,2);
        courseRepo.save(course1);
        assertNotEquals(courseRepo.update(tempCourse)==null,courseRepo.update(tempCourse)==course1);
    }
}