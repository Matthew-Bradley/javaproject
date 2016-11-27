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
public abstract class User {
    // OVERVIEW
    // This class provides the base blueprint for a user 
    // including username and password
    
    private String userName;
    private String password;
    
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public abstract void newCommand(String line);
    
    public abstract void printHelp();
    
    public boolean checkPassword(String password) {
        // REQUIRES 
        // String
        // EFFECTS
        // returns true if passwords are equal to user's password
        return this.password.compareTo(password) == 0;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        // EFFECTS
        // returns the user's username
        return userName;
    }

    public abstract void logout();
    
    public abstract String getRole();
    
}
