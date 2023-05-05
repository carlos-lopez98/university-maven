package com.solvd.university.exceptions;

public class InvalidScoreException extends RuntimeException{

    public InvalidScoreException(){
    }

    public InvalidScoreException(String message){
        super(message);
    }
}
