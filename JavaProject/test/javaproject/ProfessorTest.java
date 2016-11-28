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
public class ProfessorTest {
    
   
    /**
     * Test of getRole method, of class Professor.
     */
    @Test
    public void testGetRole() {
        System.out.println("getRole");
        Professor instance = new Professor("prof","pass");
        String expResult = "Professor";
        String result = instance.getRole();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Professor.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Professor instance = new Professor("prof","pass");
        String expResult = "Username: prof, Type of user:Professor";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of repOk method, of class Professor.
     */
    @Test
    public void testRepOk() {
        System.out.println("repOk");
        Professor instance = new Professor("prof", "pass");
        boolean expResult = true;
        boolean result = instance.repOk();
        assertEquals(expResult, result);
    }
    
}
