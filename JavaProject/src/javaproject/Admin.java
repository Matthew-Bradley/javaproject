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
    
    /*
    steps in checking each token level
    
    does the token exist?
    is it a valid variable? (ie non-empty, must be checked after we're sure it exists)
    is it a valid in the context of it's role?
    */

    //******************need to check if object already exists when creating
    @Override
    public void newCommand(String line) {
        String[] tokens = line.split(" ");
        if("create".equals(tokens[0].toLowerCase())) {
            if(tokens.length < 2) {
                System.out.println("You need to specify something to create.");
            } else {
                if("student".equals(tokens[1].toLowerCase())) {
                    
                    
                    
                    /*
                    if(true) {
                        System.out.println("Insufficient or invalid parameters supplied.");
                        System.out.println("Usage: create student <username> <password>");
                    } else {
                        User temp = new Student(tokens[2], tokens[3]);
                    }
                    */
                } else if("professor".equals(tokens[1].toLowerCase())) {
                    
                    
                    
                    /*
                    if(true) {
                        System.out.println("Insufficient or invalid parameters supplied.");
                        System.out.println("Usage: create professor <username> <password>");
                    } else {
                        JavaProject.users.add(new Professor(tokens[2], tokens[3]));
                    }
                    */
                } else if("course".equals(tokens[1].toLowerCase())) {
                    
                    
                    
                    /*
                    if(true) {
                        System.out.println("Insufficient or invalid parameters supplied.");
                        System.out.println("Usage: create course <name>");
                    } else {
                        JavaProject.courses.add(new Course(tokens[2]));
                    }
                    */
                } else {
                    System.out.println("Unknown type \"" + tokens[1] +"\".");
                }
            }
        } else if("dummyCommand".equals(tokens[0].toLowerCase())) {
            
        } else {
            System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
        }
    }

    @Override
    public void printHelp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
