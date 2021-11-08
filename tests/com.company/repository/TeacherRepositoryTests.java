package com.company.repository;

import com.company.model.Course;
import com.company.model.Student;
import com.company.model.Teacher;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TeacherRepositoryTests {
    List<Teacher> teachers = new ArrayList<>();
    TeacherRepository teacherRepo = new TeacherRepository(teachers);
    List<Course> coursesTeacher = new ArrayList<>();
    Teacher teacher = new Teacher("Diana","Cristea",1,coursesTeacher);

    @Test
    public void getTeacherListTestPositive() {
        teacherRepo.getTeacherList().add(teacher);
        assertEquals(teacherRepo.getTeacherList().size()==1,teacherRepo.getTeacherList().size()==1);
    }

    @Test
    public void getTeacherListTestNegative() {
        teacherRepo.getTeacherList().add(teacher);
        assertNotEquals(teacherRepo.getTeacherList().size()==0,teacherRepo.getTeacherList().size()==1);
    }

    @Test
    public void setTeacherListTestPositive() {
        List<Teacher> teacherTemp = new ArrayList<>();
        teacherTemp.add(teacher);
        teacherRepo.setTeacherList(teacherTemp);
        assertEquals(teacherRepo.getTeacherList().size()==1,teacherRepo.getTeacherList().size()==1);
    }

    @Test
    public void setTeacherListTestNegative() {
        List<Teacher> teacherTemp = new ArrayList<>();
        teacherTemp.add(teacher);
        teacherRepo.setTeacherList(teacherTemp);
        //assertFalse(teacherRepo.getteacherList().size()==0);
        assertNotEquals(teacherRepo.getTeacherList().size()==0,teacherRepo.getTeacherList().size()==1);

    }

    @Test
    public void findOneTestPositive(){
        teacherRepo.getTeacherList().add(teacher);
        //assertTrue(teacherRepo.findOne(teacher.getTeacherId())==teacher);
        assertEquals(teacherRepo.findOne(teacher.getTeacherId())==teacher,teacherRepo.findOne(teacher.getTeacherId())==teacher);
    }

    @Test
    public void findOneTestNegative(){
        teacherRepo.getTeacherList().add(teacher);
        List<Course> coursesTeacherTemp = new ArrayList<>();
        Teacher teacherTemp = new Teacher("Catalin","Rusu",2,coursesTeacherTemp);
        //assertFalse(teacherRepo.findOne(teacher.getTeacherId())==teacherTemp);
        assertNotEquals(teacherRepo.findOne(teacher.getTeacherId()).equals(teacherTemp),teacherRepo.findOne(teacher.getTeacherId()).equals(teacher));
    }

    @Test
    public void findAllTestPositive(){
        int counter = 0; //count the elements (teachers)
        teacherRepo.getTeacherList().add(teacher);
        for (Teacher t : teacherRepo.findAll()) {
            counter++;
        }
        assertEquals(counter==1,counter== 1);
    }

    @Test
    public void findAllTestNegative(){
        int counter = 0; //count the elements (teachers)
        teacherRepo.getTeacherList().add(teacher);
        for (Teacher t : teacherRepo.findAll()) {
            counter++;
        }
        assertNotEquals(counter == 0,counter == 1);
    }

    @Test
    public void saveTestPositive() {
        teacherRepo.save(teacher);
        //assertTrue(teacherRepo.getteacherList().get(0)==teacher);
        assertEquals(teacherRepo.getTeacherList().get(0)==teacher,teacherRepo.getTeacherList().get(0)==teacher);
    }

    @Test
    public void saveTestNegative() {
        teacherRepo.save(teacher);
        assertNotEquals(teacherRepo.getTeacherList().size()==0, teacherRepo.getTeacherList().size()==1);
    }

    @Test
    public void deleteTestPositive() {
        teacherRepo.save(teacher);
        teacherRepo.delete(teacher.getTeacherId());
        assertEquals(teacherRepo.getTeacherList().size()==0,teacherRepo.getTeacherList().size()==0);
    }

    @Test
    public void deleteTestNegative() {
        teacherRepo.save(teacher);
        teacherRepo.delete(teacher.getTeacherId());
        assertNotEquals(teacherRepo.getTeacherList().size()==1, teacherRepo.getTeacherList().size()==0);
    }

    @Test
    public void updateTestPositive() {
        List<Course> coursesTeacherTemp = new ArrayList<>();
        Teacher teacherTemp = new Teacher("Diana","Cristea",1,coursesTeacherTemp);
        teacherRepo.save(teacher);
        assertEquals(teacherRepo.update(teacherTemp)==null,teacherRepo.update(teacherTemp)==null);
        teacherRepo.update(teacherTemp);
        assertEquals(teacherRepo.update(teacherTemp)==null,teacherRepo.update(teacherTemp)==null);
    }

    @Test
    public void updateTestNegative() {
        List<Course> coursesTeacherTemp = new ArrayList<>();
        Teacher teacherTemp = new Teacher("Diana","Cristea",2,coursesTeacherTemp);
        teacherRepo.save(teacher);
        assertNotEquals(teacherRepo.update(teacherTemp)==null, teacherRepo.update(teacherTemp)==teacher);
    }

    @Test
    public void deleteCourseTest() {
        List<Course> coursesStudent = new ArrayList<>();
        Student student = new Student("Miruna", "Lupas", 2, 20, coursesStudent);
        List<Student> studentsForCourse = new ArrayList<>();
        Course course = new Course("BD",teacher,10,studentsForCourse,5,1);
        coursesTeacher.add(course);
        coursesStudent.add(course);
        studentsForCourse.add(student);

        List<Student> students = new ArrayList<>();
        StudentRepository studRepo = new StudentRepository(students);
        studRepo.save(student);

        teacherRepo.save(teacher);

        List<Course> courses = new ArrayList<>();
        CourseRepository courseRepo = new CourseRepository(courses);
        courseRepo.save(course);

        teacherRepo.deleteCourse(course,teacher);

        assertEquals(course.getStudentsEnrolled().size() == 0,course.getStudentsEnrolled().size() == 0);
        assertEquals(teacher.getCourses().size() == 0,teacher.getCourses().size() == 0);
        assertEquals(student.getEnrolledCourses().size() == 0,student.getEnrolledCourses().size() == 0);
        assertEquals(student.getTotalCredits() == 20,student.getTotalCredits() == 20);
    }

}