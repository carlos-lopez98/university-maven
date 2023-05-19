package com.solvd.university.models.departments;

import com.solvd.university.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ScienceDep extends Department implements Budget {

    private Logger logger = LogManager.getLogger(Main.class);

    private List<String> fieldTripLocations;

    public ScienceDep(String departmentTeamName) {
        super(departmentTeamName);
    }

    @Override
    public void seeDepartmentTutoringHours() {
        logger.info("Hours: M-F 10AM - 12PM");
    }

    @Override
    public void showBudget() {
        logger.info("This Semester's Budget for the Science Department is $200,000");
    }

    public List<String> getFieldTripLocations() {
        return fieldTripLocations;
    }

    public void setFieldTripLocations(List<String> fieldTripLocations) {
        this.fieldTripLocations = fieldTripLocations;
    }
}
