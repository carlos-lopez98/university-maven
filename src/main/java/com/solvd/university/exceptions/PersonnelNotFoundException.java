package com.solvd.university.exceptions;

public class PersonnelNotFoundException extends RuntimeException {

    public PersonnelNotFoundException(){};
    public PersonnelNotFoundException(String message){
        super(message);
    };
}

