package com.company.repository;

import static org.junit.jupiter.api.Assertions.*;
import com.company.model.Course;
import com.company.model.Student;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryTests {
    List<Student> students = new ArrayList<>();
    StudentRepository studentRepo = new StudentRepository(students);
    List<Course> coursesStudent1 = new ArrayList<>();
    List<Course> coursesStudent2 = new ArrayList<>();
    Student student1 = new Student("Miruna", "Lupas", 1, 30, coursesStudent1);
    Student student2 = new Student("Monika", "Popescu", 2, 28, coursesStudent2);

    @Test
    public void getStudentListTestPositive() {
        studentRepo.getstudentList().add(student1);
        assertEquals(studentRepo.getstudentList().size()==1,studentRepo.getstudentList().size()==1);
    }

    @Test
    public void getStudentListTestNegative() {
        studentRepo.getstudentList().add(student1);
        assertNotEquals(studentRepo.getstudentList().size()==0, studentRepo.getstudentList().size()==1);
    }

    @Test
    public void setStudentListTestPositive() {
        List<Student> studentTemp = new ArrayList<>();
        studentTemp.add(student1);
        studentRepo.setstudentList(studentTemp);
        assertEquals(studentRepo.getstudentList().size()==1,studentRepo.getstudentList().size()==1);
    }

    @Test
    public void setStudentListTestNegative() {
        List<Student> studentTemp = new ArrayList<>();
        studentTemp.add(student1);
        studentRepo.setstudentList(studentTemp);
        assertNotEquals(studentRepo.getstudentList().size()==0,studentRepo.getstudentList().size()==1);
    }

    @Test
    public void findOneTestPositive(){
        studentRepo.getstudentList().add(student1);
        assertEquals(studentRepo.findOne(student1.getStudentId())==student1,studentRepo.findOne(student1.getStudentId())==student1);
    }

    @Test
    public void findOneTestNegative(){
        studentRepo.getstudentList().add(student1);
        assertNotSame(studentRepo.findOne(student1.getStudentId())==student2,studentRepo.findOne(student1.getStudentId())==student1);
    }

    @Test
    public void findAllTestPositive(){
        int counter = 0; //count the elements (students)
        studentRepo.getstudentList().add(student1);
        for (Student s : studentRepo.findAll()) {
            counter++;
        }
        assertEquals(counter == 1, counter ==1);
    }

    @Test
    public void findAllTestNegative(){
        int counter = 0; //count the elements (students)
        studentRepo.getstudentList().add(student1);
        for (Student s : studentRepo.findAll()) {
            counter++;
        }
        assertNotEquals(counter == 0,counter ==1);
    }

    @Test
    public void saveTestPositive() {
        studentRepo.save(student1);
        assertSame(studentRepo.getstudentList().get(0)==student1,studentRepo.getstudentList().get(0)==student1);
    }

    @Test
    public void saveTestNegative() {
        studentRepo.save(student1);
        assertNotEquals(studentRepo.getstudentList().size()==0,studentRepo.getstudentList().size()==1);
    }

    @Test
    public void deleteTestPositive() {
        studentRepo.save(student1);
        studentRepo.delete(student1.getStudentId());
        assertEquals(studentRepo.getstudentList().size()==0, studentRepo.getstudentList().size()==0);
    }

    @Test
    public void deleteTestNegative() {
        studentRepo.save(student1);
        studentRepo.delete(student1.getStudentId());
        assertNotEquals(studentRepo.getstudentList().size()==1, studentRepo.getstudentList().size() == 0);
    }

    @Test
    public void updateTestPositive() {
        List<Course> coursesStudentTemp = new ArrayList<>();
        Student tempStudent = new Student("Monika", "Popescu", 1, 28, coursesStudentTemp);
        studentRepo.save(student1);
        assertEquals(studentRepo.update(tempStudent)==null,studentRepo.update(tempStudent) == null);
        studentRepo.update(tempStudent);
        assertSame(studentRepo.getstudentList().get(0).getFirstName().equals("Monika"),studentRepo.getstudentList().get(0).getFirstName().equals("onika"));
        assertEquals(studentRepo.getstudentList().get(0).getTotalCredits()==28,studentRepo.getstudentList().get(0).getTotalCredits()==28);
    }

    @Test
    public void updateTestNegative() {
        List<Course> coursesStudentTemp = new ArrayList<>();
        Student tempStudent = new Student("Miruna", "Lupas", 2, 30, coursesStudentTemp);
        studentRepo.save(student1);
        assertNotSame(studentRepo.update(tempStudent)== null, studentRepo.update(tempStudent)== student1);
    }
}