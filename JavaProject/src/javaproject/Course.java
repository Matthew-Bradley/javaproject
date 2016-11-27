/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.util.ArrayList;

/**
 *
 * @author m
 */
class Course {
    
    // OVERVIEW
    // the course class can be assigned to students
    // and contains a list of assignments belonging to the course
    
    // AF(c) = { c.getName() == this.name && this.students != null && this.assignments != null }
    
    // rep invariant
    // s.getRole.equals("Professor") &&
    // s.getUserName() == this.userName &&
    // s.checkPassword == true
    
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
    
    Course(String name) {
        this.name  = name;
    }
    
    public void addStudent(String name) {
        this.students.add((Student) JavaProject.getUserFromName(name));
    }
    
    public boolean checkStudent(String name) {
        for (Student stu : students) {
            if(name.compareTo(stu.getUserName()) == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean checkAssignmentIsDuplicate(String userName, String name) {
        for (Assignment assign : assignments) {
            if(name.compareTo(assign.getName()) == 0 && userName.compareTo(assign.getStudentName()) == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public void addAssignment(String studentName, String name, Double mark) {
        this.assignments.add(new Assignment((Student) JavaProject.getUserFromName(studentName), name, mark));
    }
    
    public void printMarks(String name) {
        Student student = (Student) JavaProject.getUserFromName(name);
        
        if (student != null) { // if student is unspecified, print all students
            for (Assignment assign : assignments) {
                if(assign.getStudentName().compareTo(student.getUserName()) == 0) {
                    System.out.println("Assignment: " + assign.getName() + "\tMark: " + assign.getMark());
                }
            }
        } else {
            for (Assignment assign : assignments) {
                System.out.println("Student: " + assign.getStudentName() + "\tAssignment: " + assign.getName() + "\tMark: " + assign.getMark());
            }
        }
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
        
    @Override
    public String toString(){
        return "Username: ";
    }
    
    public boolean repOk() {

        return true;
    }
}
