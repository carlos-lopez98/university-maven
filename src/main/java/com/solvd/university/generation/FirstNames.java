package com.solvd.university.generation;

public enum FirstNames {
    JOHN,
    MICHELLE,
    GERALD,
    CARLOS,
    MARY;


    //Overrides the toString() method to return a capitalized version of the name
    @Override
    public String toString(){
        String firstName = name();
        String lowercase = firstName.substring(1).toLowerCase();

        return firstName.charAt(0) + lowercase;
    }
}
