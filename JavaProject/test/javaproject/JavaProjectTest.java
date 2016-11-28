/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import static javaproject.JavaProject.users;
import static javaproject.JavaProject.courses;
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
public class JavaProjectTest {
    
    public JavaProjectTest() {
        users.add(new Professor("prof1", "pass"));
        users.add(new Professor("prof2", "pass"));
        users.add(new Student("stud1", "pass"));
        users.add(new Student("stud2", "pass"));
        courses.add(new Course("course1"));
        courses.add(new Course("course2"));
    }
    

    /**
     * Test of getCourseFromName method, of class JavaProject.
     */
    @Test
    public void testGetCourseFromName() {
        System.out.println("getCourseFromName");
        String name = "course1";
        Course result = JavaProject.getCourseFromName(name);
        assertEquals(result.getName(), name);
    }
    @Test
    public void testGetUserFromName() {
        System.out.println("getUserFromName");
        String name = "stud1";
        User result = JavaProject.getUserFromName(name);
        assertEquals(result.getUserName(), name);
    }
    
}
