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
public class CourseTest {
    
    public CourseTest() {
    }
    
    /**
     * Test of getName method, of class Course.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Course instance = new Course("course");
        String expResult = "course";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setName method, of class Course.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "course";
        Course instance = new Course("course");
        instance.setName(name);
        assertEquals(name, instance.getName());
    }


    
}
