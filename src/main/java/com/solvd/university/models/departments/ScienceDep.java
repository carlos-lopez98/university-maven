package com.solvd.university.models.departments;

import java.util.List;

public class ScienceDep extends Department implements Budget {

    private List<String> fieldTripLocations;

    public ScienceDep(String departmentTeamName) {
        super(departmentTeamName);
    }

    @Override
    public void seeDepartmentTutoringHours() {
        System.out.println("Hours: M-F 10AM - 12PM");
    }

    @Override
    public void showBudget() {
        System.out.println("This Semester's Budget for the Science Department is $200,000");
    }

    public List<String> getFieldTripLocations() {
        return fieldTripLocations;
    }

    public void setFieldTripLocations(List<String> fieldTripLocations) {
        this.fieldTripLocations = fieldTripLocations;
    }
}
