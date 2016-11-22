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
        if("create".equals(tokens[0].toLowerCase()) && tokens.length == 2) {
            if("student".equals(tokens[1].toLowerCase())) {
                System.out.println("Sorry. Unimplemented.");
                //TODO implement
                
            } else if("professor".equals(tokens[1].toLowerCase())) {
                System.out.println("Sorry. Unimplemented.");
                //TODO implement
                
            } else if("course".equals(tokens[1].toLowerCase())) {
                System.out.println("Sorry. Unimplemented.");
                //TODO implement
                
            } else {
                System.out.println("Unknown type \"" + tokens[1] +"\"");
            }
        } else if("command2".equals(tokens[0].toLowerCase())) {
            
        } else {
            System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
        }
    }

    @Override
    public void printHelp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
