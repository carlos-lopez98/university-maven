package com.solvd.university.exceptions;

public class UniversityNotFoundException extends RuntimeException{

    public UniversityNotFoundException(){};

    public UniversityNotFoundException(String message){
        super(message);
    };
}
