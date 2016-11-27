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
    // OVERVIEW
    // this class is a child class of user,
    // and provides the commands which a student would have access to
    // such as viewing marks, and showing enrolled courses
    
    // AF(s) = { s.getUserName() == this.userName && s.checkPassword == true }
    
    // s.getRole.equals("Student") &&
    // s.getUserName() == this.userName &&
    // s.checkPassword == true
    public Student(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void newCommand(String line) {
        
        // REQUIRES
        // string from command line
        // EFFECTS
        // depending on command, will return a different output
        // if the command is print_marks,
        // will print the student's mark
        // if the commands is show_courses,
        // will print list of student's enrolled courses
        
        String[] tokens = line.split(" ");
        if("print_marks".equals(tokens[0].toLowerCase())) {
            for(Course core : JavaProject.courses) {
                if(core.checkStudent(this.getUserName())){
                    System.out.println("For course: " + core.getName());
                }
                core.printMarks(this.getUserName());
            }
        } else if("show_courses".equals(tokens[0].toLowerCase())) {
            System.out.println("Courses:");
            for(Course core : JavaProject.courses) {
                if(core.checkStudent(this.getUserName())) {
                    System.out.println(core.getName());
                }
            }
        } else {
            System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
        }
    }

    @Override
    public void printHelp() {
        // EFFECTS 
        // if user enters the help command, will print list of available functions
        System.out.println("show_courses");
        System.out.println("    -Shows all enrolled courses.");
        System.out.println("print_marks");
        System.out.println("    -Shows all marks on all assignments in all courses.");
    }

    @Override
    public void logout() {
        //nothing to do
    }

    @Override
    public String getRole() {
        // EFFECTS
        // returns the role of the user (student)
        return "Student";
    }
    
    @Override
    public String toString(){
        return "Username: " + this.getUserName() + ", Type of user:" + this.getRole();
    }
    
    public boolean repOk() {
        String un = this.getUserName();
        if(!(this.getRole().equals("Student"))) {
            return false;
        }
        if(!(un instanceof String)){
            return false;
        }
        return true;
    }
}
