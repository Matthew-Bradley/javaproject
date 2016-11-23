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
        if("create".equals(tokens[0].toLowerCase())) {
            if(tokens.length >= 2) {
                if("student".equals(tokens[1].toLowerCase())) { //******************need to check if object already exists
                    if(tokens.length == 4 && tokens[2].length() > 0 && tokens[3].length() > 0) {
                        User temp = new Student(tokens[2], tokens[3]);
                    } else {
                        System.out.println("Insufficient or invalid parameters supplied.");
                        System.out.println("Usage: create student <username> <password>");
                    }
                } else if("professor".equals(tokens[1].toLowerCase())) {
                    if(tokens.length == 4 && tokens[2].length() > 0 && tokens[3].length() > 0) {
                        JavaProject.users.add(new Professor(tokens[2], tokens[3]));
                    } else {
                        System.out.println("Insufficient or invalid parameters supplied.");
                        System.out.println("Usage: create professor <username> <password>");
                    }
                } else if("course".equals(tokens[1].toLowerCase())) {
                    if(tokens.length == 3 && tokens[2].length() > 0) {
                        JavaProject.courses.add(new Course(tokens[2]));
                    } else {
                        System.out.println("Insufficient or invalid parameters supplied.");
                        System.out.println("Usage: create course <name>");
                    }
                } else {
                    System.out.println("Unknown type \"" + tokens[1] +"\".");
                }
            } else {
                System.out.println("You need to specify something to create.");
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
