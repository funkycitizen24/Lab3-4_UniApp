package com.company.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PersonTests {
    private static Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Miruna","Lupas");
    }

    @Test
    void getFirstNameTestPositive(){
        assertTrue(person.getFirstName().equals("Miruna"));
    }

    @Test
    void getFirstNameTestNegative(){
        assertFalse(person.getFirstName().equals("Monika"));
    }

    @Test
    void setFirstNameTestPositive(){
        person.setFirstName("Monika");
        assertTrue(person.getFirstName().equals("Monika"));
    }

    @Test
    void setFirstNameTestNegative(){
        person.setFirstName("Monika");
        assertFalse(person.getFirstName().equals("Miruna"));
    }

    @Test
    void getLastNameTestPositive(){
        assertTrue(person.getLastName().equals("Lupas"));
    }

    @Test
    void getLastNameTestNegative(){
        assertFalse(person.getLastName().equals("Popescu"));
    }

    @Test
    void setLastNameTestPositive(){
        person.setLastName("Popescu");
        assertTrue(person.getLastName().equals("Popescu"));
    }

    @Test
    void setLastNameTestNegative(){
        person.setLastName("Popescu");
        assertFalse(person.getLastName().equals("Lupas"));
    }
}