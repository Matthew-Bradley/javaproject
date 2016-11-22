/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaproject;

import java.util.ArrayList;
import java.util.Scanner;

/*
 *
 *
 * @author m
 */
public class JavaProject {
    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Course> courses = new ArrayList<>();
    
    //course array can be accessed from anywhere as:
    //"JavaProject.courses"
    //might move to handing out resources to admin, who attaches students
    //and professors in the future, if I can figure it out, but this works
    //pretty well

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        User user = null;
        
        users.add(Admin.getInstance());
        
        while (true)
        {
            if(scan.hasNextLine())
            {
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                
                if("exit".equals(tokens[0].toLowerCase()))//series of if statements should probably be replaced, perhaps with a pattern
                    break;
                else if("help".equals(tokens[0].toLowerCase())) {
                    System.out.println("Basic Commands:");
                    System.out.println("exit: Exit the application.");
                    System.out.println("help: Print this help information.");
                    System.out.println("login: Login to a user account.");
                    System.out.println("logout: log out from a user account.");
                    
                    if(user != null) {
                        System.out.println("User specific help:");
                        user.printHelp();
                    } else {
                        System.out.println("Additional commands are available to authenticated users.");
                    }
                } else if("login".equals(tokens[0].toLowerCase())) {
                    if(user == null){
                        System.out.println("Enter Username:");
                        String username = scan.nextLine();
                        
                        User potenUser = null;
                        for(User use : users) {
                            if(use.getUserName().compareTo(username) == 0) {
                                potenUser = use;
                                break;
                            }
                        }
                        
                        if(potenUser != null) {
                            System.out.println("Enter Password:");
                            String password = scan.nextLine();
                            
                            if(potenUser.checkPassword(password)) {
                                user = potenUser;
                                System.out.println("Welcome " + user.getUserName() + "!");
                            } else {
                                System.out.println("Password incorrect.");
                            }
                        } else {
                            System.out.println("User not found.");
                        }
                    } else {
                        System.out.println("You are already logged in, " + user.getUserName() + ".");
                        System.out.println("See \"help\" for information on logging out");
                    } 
                } else if("logout".equals(tokens[0].toLowerCase())) {
                    if (user != null) {
                        System.out.println("Are you sure you want to logout? (\"Yes\" to log out)");
                        String response = scan.nextLine();
                        
                        if(response.compareTo("Yes") == 0){
                            user = null;
                            System.out.println("You have been logged out.");
                        } else {
                            System.out.println("You must enter \"Yes\" to log out.");
                        }
                    } else {
                        System.out.println("You are not logged in as an authenticated user.");
                    }
                } else if(user != null)
                    user.newCommand(line);
                else
                    System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
                                
            }
            
        }
    }
    
}
