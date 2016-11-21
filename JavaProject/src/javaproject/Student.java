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
        if("command1".equals(tokens[0].toLowerCase())) {
            
        } else if("command2".equals(tokens[0].toLowerCase())) {
            
        } else {
            System.out.println("You are not logged in as an authenticated user.");
        }
    }

    @Override
    public void printHelp() {
        System.out.println("<Some command help for students>");
    }
    
}
