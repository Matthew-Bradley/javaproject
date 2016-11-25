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
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Assignment> assignments = new ArrayList<>();
    
    Course(String name) {
        this.name  = name;
    }
    
    public void addStudent(Student student) {
        this.students.add(student);
    }
    
    public boolean checkStudent(Student student) {
        for (Student stu : students) {
            if(student == stu) {
                return true;
            }
        }
        
        return false;
    }
    
    public void addAssignment(Student student, String name, Double mark) {
        this.assignments.add(new Assignment(student, name, mark));
    }
    
    public void printMarks(Student student) {
        if (student != null) { // if student is unspecified, print all students
            for (Assignment assign : assignments) {
                if(assign.getName().compareTo(student.getUserName()) == 0) {
                    System.out.println("Assignment: " + assign.getName() + "\tMark: " + assign.getMark());
                }
            }
        } else {
            for (Assignment assign : assignments) {
                System.out.println("Sudent: " + assign.getStudentName() + "Assignment: " + assign.getName() + "\tMark: " + assign.getMark());
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
}
