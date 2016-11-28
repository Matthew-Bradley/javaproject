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
class Assignment {
    // OVERVIEW
    // the assignment class belongs to a student
    // and has an assignment name
    // as well as a grade (mark) associated with it
    
    // AF(s) = { s.getStudentName() | this.student instanceof String
    //           s.getName() | this.name instanceof String
    //           s.getMark() | this.mark instanceof Double   }
    
    // rep invariant
    // s.getName() != null && s.getMark() != null && s.getStudentName() != null
    
    private Student student;
    private String name;
    private Double mark;
    
    Assignment(Student student, String name, Double mark) {
        this.student = student;
        this.name = name;
        this.mark = mark;
    }
    
    /**
     * @return the student's name
     */
    public String getStudentName() {
        return student.getUserName();
    }
    

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the mark
     */
    public Double getMark() {
        return mark;
    }
    
        
    @Override
    public String toString(){
        return "Assignment " + this.getName() + " belongs to " + this.getStudentName() + " with mark of " + this.getMark();
    }
    
    public boolean repOk() {
        if(!(this.getName() instanceof String && this.getStudentName() instanceof String)){
            return false;
        }
        if(this.getMark() == null){
            return false;
        }
        return true;
    }
}
