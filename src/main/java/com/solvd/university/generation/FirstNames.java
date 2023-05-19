package com.solvd.university.generation;

public enum FirstNames {
    JOHN("John"),
    MICHELLE("Michelle"),
    GERALD("Gerald"),
    CARLOS("Carlos"),
    MARY("Mary");


    private final String firstName;

    FirstNames(String firstName){this.firstName = firstName;}

    public String getFirstName(){
    return this.firstName;
}
}
