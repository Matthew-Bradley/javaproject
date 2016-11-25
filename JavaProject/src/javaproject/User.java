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
    private String userName;
    private String password;
    
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public abstract void newCommand(String line);
    
    public abstract void printHelp();
    
    public boolean checkPassword(String password) {
        return this.password.compareTo(password) == 0;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    public abstract void logout();
    
}
