package com.company.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTests {
    private static Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Miruna","Lupas");
    }

    @Test
    void getFirstNameTestPositive(){
        assertEquals(person.getFirstName().equals("Miruna"),person.getFirstName().equals("Miruna"));
    }

    @Test
    void getFirstNameTestNegative(){
        assertNotEquals(person.getFirstName().equals("Monika"),person.getFirstName().equals("Miruna"));
    }

    @Test
    void setFirstNameTestPositive(){
        person.setFirstName("Monika");
        assertEquals(person.getFirstName().equals("Monika"),person.getFirstName().equals("Monika"));
    }

    @Test
    void setFirstNameTestNegative(){
        person.setFirstName("Monika");
        assertNotEquals(person.getFirstName().equals("Miruna"),person.getFirstName().equals("Monika"));
    }

    @Test
    void getLastNameTestPositive(){
        assertEquals(person.getLastName().equals("Lupas"),person.getLastName().equals("Lupas"));
    }

    @Test
    void getLastNameTestNegative(){
        assertNotEquals(person.getLastName().equals("Popescu"),person.getLastName().equals("Lupas"));
    }

    @Test
    void setLastNameTestPositive(){
        person.setLastName("Popescu");
        assertEquals(person.getLastName().equals("Popescu"),person.getLastName().equals("Popescu"));
    }

    @Test
    void setLastNameTestNegative(){
        person.setLastName("Popescu");
        assertNotEquals(person.getLastName().equals("Lupas"),person.getLastName().equals("Popescu"));
    }
}