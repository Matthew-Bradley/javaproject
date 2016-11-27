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
public class Professor extends User{
    // OVERVIEW
    // this class is a child class of user,
    // and provides the commands which a professor would have access to
    // such as managing grades, courses, and assignments
    
    Course selectedCourse = null;

    public Professor(String userName, String password) {
        super(userName, password);
    }

    @Override
    public void newCommand(String line) {      
        // REQUIRES
        // string from command line
        // EFFECTS
        // depending on command, will return a different output
        // commands available are :
        // select course - change "selected" course
        // show course - shows a single course
        // show courses - lists all courses
        // show users - lists all users
        // show assignments - lists all assignments
        // show enrolled students - lists students currently enrolled in classes
        // add student - adds a student to selected course

        String[] tokens = line.split(" ");
        if("select_course".equals(tokens[0].toLowerCase())) {
            if(tokens.length != 2) { // check that a course was specified
                System.out.println("You need to specify a course");
            } else {
                if(JavaProject.getCourseFromName(tokens[1]) == null) { // check course exists
                    System.out.println("Course must exist.");
                } else {
                    selectedCourse = JavaProject.getCourseFromName(tokens[1]);
                    System.out.println(selectedCourse.getName() + " selected.");
                }    
            }
        } else if("show_course".equals(tokens[0].toLowerCase())) {
            if(selectedCourse == null) { // check if a course is selected
                System.out.println("No course selected.");
            } else {
                System.out.println(selectedCourse.getName() + " selected.");
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
        } else if("show_assignments".equals(tokens[0].toLowerCase())) {
            if(selectedCourse != null) { // check if a course is selected
                selectedCourse.printMarks(null);
            } else {
                System.out.println("You must select a course.");
            }
        } else if("show_enrolled_students".equals(tokens[0].toLowerCase())) {
            if(selectedCourse != null) {
                System.out.println("Students:");
                for(User use : JavaProject.users) {
                    if(use instanceof Student){
                        if(selectedCourse.checkStudent(use.getUserName())) {
                            System.out.println(use.getUserName());
                        }
                    }
                }
            } else {
                System.out.println("You must select a course.");
            }
        } else if("add_student".equals(tokens[0].toLowerCase())) {
            if (selectedCourse != null) {
                if(tokens.length < 2) { // check that a student was specified
                    System.out.println("You need to specify a student");
                } else {
                    if(JavaProject.getUserFromName(tokens[1]) == null) { // check student exists
                        System.out.println("Student must exist.");
                    } else {
                        if(JavaProject.getUserFromName(tokens[1]) instanceof Student) { // check specified user is indeed a student
                            if(!selectedCourse.checkStudent(tokens[1])) {
                                selectedCourse.addStudent(tokens[1]);
                            } else {
                                System.out.println("Student is already enrolled in selected course.");
                            }
                        } else {
                            System.out.println("You must specify a student.");
                        }
                    }    
                }
            } else {
                System.out.println("You must have a course selected.");
            }
        } else if("mark".equals(tokens[0].toLowerCase())) {
            if (selectedCourse != null) {
                if(tokens.length < 4) {
                    System.out.println("You must specify a student name, assignment name, and mark.");
                } else {
                    if(JavaProject.getUserFromName(tokens[1]) == null || tokens[2].length() == 0 || tokens[3].length() == 0 || !isDouble(tokens[3])) { //check that parameters are valid
                        System.out.println("Student must exist, and assignment name and mark must be valid.");
                    } else {
                        if(JavaProject.getUserFromName(tokens[1]) instanceof Student) { // check that a student was specified
                            if(selectedCourse.checkStudent(tokens[1])) { // check that the student is in the selected course
                                if(!selectedCourse.checkAssignmentIsDuplicate(tokens[1], tokens[2])) {
                                    selectedCourse.addAssignment(tokens[1], tokens[2], Double.parseDouble(tokens[3]));
                                } else {
                                    System.out.println("Selected course already contains an assignment with that name for that student.");
                                }
                            } else {
                                System.out.println("Student must be in selected course.");
                            }
                        } else {
                            System.out.println("Student must be valid.");
                        }
                    }
                }
            } else {
                System.out.println("You must have a course selected.");
            }
        } else {
            System.out.println("Unknown Command \"" + line + "\". Try \"help\"");
        }
    }

    @Override
    public void printHelp() {
        System.out.println("select_course <course>");
        System.out.println("show_course");
        System.out.println("    -Shows currently selected course.");
        System.out.println("show_courses");
        System.out.println("    -Shows all courses.");
        System.out.println("show_users");
        System.out.println("    -Shows all users.");
        System.out.println("show_assignments");
        System.out.println("    -Shows all assignments for selected course.");
        System.out.println("show_enrolled_students");
        System.out.println("    -Shows all students in a selected course.");
        System.out.println("add_student <username>");
        System.out.println("mark <student username> <assignment name> <grade>");
        System.out.println("    -Adds a mark for an assignment for the specified student with the specified grade.");
    }

    @Override
    public void logout() {
        selectedCourse = null;
    }
    
    static private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getRole() {
        // EFFECTS
        // returns the role of the user (professor)
        return "Professor";
    }
}
