/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

/**
 *
 * @author m
 */
public class Student extends User {

    public Student(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void newCommand(String line) {
        String[] tokens = line.split(" ");
        if("print_marks".equals(tokens[0].toLowerCase())) {
            for(Course core : JavaProject.courses) {
                if (core.checkStudent(this)){
                    System.out.println("For course: " + core.getName());
                }
                
                core.printMarks(this);
            }
        } else if("show_courses".equals(tokens[0].toLowerCase())) {
            System.out.println("Courses:");
            for(Course core : JavaProject.courses) {
                System.out.println(core.getName());
            }
        } else {
            System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
        }
    }

    @Override
    public void printHelp() {
        System.out.println("show_courses");
        System.out.println("    -Shows all courses.");
        System.out.println("print_marks");
        System.out.println("    -Shows all marks on all assignments in all courses.");
    }

    @Override
    public void logout() {
        //nothing to do
    }
    
}
