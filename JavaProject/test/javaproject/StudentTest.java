/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author cdok
 */
public class StudentTest {

    /**
     * Test of getRole method, of class Student.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Student instance = new Student("student","pass");
        String expResult = "Student";
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Student.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Student instance = new Student("student","pass");
        String expResult = "Username: student, Type of user:Student";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of repOk method, of class Student.
     */
    @Test
    public void testRepOk() {
        System.out.println("repOk");
        Student instance = new Student("student", "pass");
        boolean expResult = true;
        boolean result = instance.repOk();
        assertEquals(expResult, result);
    }
    
}
