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
        
        System.out.println("Welcome. For help, type \"help\" and press enter.");
        
        while (true)
        {
            if(scan.hasNextLine())
            {
                String line = scan.nextLine();
                String[] tokens = line.split(" ");
                
                if("exit".equals(tokens[0].toLowerCase())) {
                    break;
                } else if("help".equals(tokens[0].toLowerCase())) {
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
                    if (user == null) {
                        System.out.println("Enter Username:");
                        String userName = scan.nextLine();

                        User potenUser = JavaProject.getUserFromName(userName);

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
                        System.out.print("You are already logged in.");
                    }
                } else if("logout".equals(tokens[0].toLowerCase())) {
                    if (user != null) {
                        System.out.println("Are you sure you want to logout? (\"Yes\" to log out)");
                        String response = scan.nextLine();

                        if(response.compareTo("Yes") == 0){
                            user.logout();
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
    
    static User getUserFromName(String name) {
        User temp = null;
        
        for (User use : JavaProject.users) {
            if (use.getUserName().compareTo(name) == 0)
                temp = use;
        }
        
        return temp;
    }
    
    static Course getCourseFromName(String name) {
        Course temp = null;
        
        for (Course course : JavaProject.courses) {
            if (course.getName().compareTo(name) == 0)
                temp = course;
        }
        
        return temp;
    }
}
