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
    // OVERVIEW
    // this class is a child class of user,
    // provides the "admin" interface for managing courses, students, and professors
    
    // AF(s) = { s.getUserName() == this.userName && s.checkPassword == true }
    
    // s.getRole.equals("Admin") &&
    // s.getUserName() == this.userName &&
    // s.checkPassword == true
    
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
            if(tokens.length < 2) { //check that a type was specified
                System.out.println("You need to specify something to create.");
            } else {
                if("student".equals(tokens[1].toLowerCase())) { //check if it was a student
                    if(tokens.length < 4) { //make sure a username and password were specified
                        System.out.println("You need to specify a username and password.");
                    } else {
                        if(tokens[2].length() == 0 || tokens[3].length() == 0){ // make sure username an password are nonzero
                            System.out.println("You need to specify a username and password.");
                        } else {
                            if(JavaProject.getUserFromName(tokens[2]) == null) { // make sure user doesn't already exist
                                JavaProject.users.add(new Student(tokens[2], tokens[3]));
                            } else {
                                System.out.println("User \"" + tokens[2] + "\" already exists.");
                            }
                        }
                    }
                } else if("professor".equals(tokens[1].toLowerCase())) { //check if it was a professor
                    if(tokens.length < 4) { //make sure a username and password were specified
                        System.out.println("You need to specify a username and password.");
                    } else {
                        if(tokens[2].length() == 0 || tokens[3].length() == 0){ // make sure username an password are nonzero
                            System.out.println("You need to specify a username and password.");
                        } else {
                            if(JavaProject.getUserFromName(tokens[2]) == null) { // make sure user doesn't already exist
                                JavaProject.users.add(new Professor(tokens[2], tokens[3]));
                            } else {
                                System.out.println("User \"" + tokens[2] + "\" already exists.");
                            }
                        }
                    }
                } else if("course".equals(tokens[1].toLowerCase())) { //check if it was a course
                    if(tokens.length < 3) { //make sure name was specified
                        System.out.println("You need to specify a name for the course.");
                    } else {
                        if(tokens[2].length() == 0){ // make sure name is nonzero
                            System.out.println("You need to specify a name for the course.");
                        } else {
                            if(JavaProject.getCourseFromName(tokens[2]) == null) { // make sure course doesn't already exist
                                JavaProject.courses.add(new Course(tokens[2]));
                            } else {
                                System.out.println("Course \"" + tokens[2] + "\" already exists.");
                            }
                        }
                    }
                } else {
                    System.out.println("Unknown type \"" + tokens[1] +"\".");
                }
            } 
        } else if("show_courses".equals(tokens[0].toLowerCase())) {
            System.out.println("Courses:");
            for(Course core : JavaProject.courses) {
                System.out.println(core.getName());
            }
        } else if("show_users".equals(tokens[0].toLowerCase())) {
            System.out.println("Users:");
            for(User use : JavaProject.users) {
                System.out.println("Username: " + use.getUserName() + " Type: " + use.getRole());
            }
        } else {
            System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
        }
    }

    @Override
    public void printHelp() {
        System.out.println("Create");
        System.out.println("    -Creates various objects. Usage:");
        System.out.println("    create student <username> <password>");
        System.out.println("    create professor <username> <password>");
        System.out.println("    create course <name>");
        System.out.println("show_courses");
        System.out.println("    -Shows all courses.");
        System.out.println("show_users");
        System.out.println("    -Shows all users.");
    }

    @Override
    public void logout() {
        //nothing to be done
    }

    @Override
    public String getRole() {
        return "Admin";
    }
    
    @Override
    public String toString(){
        return "Username: " + this.getUserName() + ", Type of user:" + this.getRole();
    }
    
    public boolean repOk() {
        String un = this.getUserName();
        if(!(this.getRole().equals("Admin"))) {
            return false;
        }
        if(!(un instanceof String)){
            return false;
        }
        return true;
    }
}
