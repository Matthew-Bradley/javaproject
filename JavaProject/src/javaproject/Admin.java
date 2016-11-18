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
public class Admin extends User{
    private static final Admin oneTimeInstance = new Admin("Admin", "Admin");

    private Admin(String userName, String password) {
        super(userName, password);
    }
    
    public static Admin getInstance(){
        return oneTimeInstance;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
