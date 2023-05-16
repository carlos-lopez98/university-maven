package com.solvd.university.generation;

public enum LastNames {

    WHITE,
    SMITH,
    DOE,
    PRIOR,
    FELT;

    //Returns capitalized lastname
    @Override
    public String toString(){
        String lastName = name();
        String lowercase = lastName.substring(1).toLowerCase();

        return lastName.charAt(0) + lowercase;
    }
}
