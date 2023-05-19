package com.solvd.university.generation;

public enum LastNames {

    WHITE("White"),
    SMITH("Smith"),
    DOE("Doe"),
    PRIOR("Prior"),
    FELT("Felt");

    private final String lastName;

    LastNames(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
