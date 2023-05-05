package com.solvd.university.exceptions;

public class CourseNotFoundException extends RuntimeException{

    public CourseNotFoundException(){
    }

    public CourseNotFoundException(String message){
        super(message);
    }
}
