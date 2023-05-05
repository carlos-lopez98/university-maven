package com.solvd.university.exceptions;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(){};

    public StudentNotFoundException(String message){
        super(message);
    };
}
