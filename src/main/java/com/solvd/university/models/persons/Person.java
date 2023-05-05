package com.solvd.university.models.persons;

public abstract class Person {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;

    private String uniAssigned;

    Person(String firstName, String lastName, String uniAssigned) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.uniAssigned = uniAssigned;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUniAssigned() {
        return uniAssigned;
    }

    public void setUniAssigned(String uniAssigned) {
        this.uniAssigned = uniAssigned;
    }
}
