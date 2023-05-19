package com.solvd.university.models.persons;

import com.solvd.university.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Staff extends Person implements Speak {

    private Logger logger = LogManager.getLogger(Main.class);

    private String dateHired;
    private String staffJob;
    private int staffID;

    public Staff(String firstName, String lastName, String uniAssigned) {
        super(firstName, lastName, uniAssigned);
    }

    public String getDateHired() {
        return dateHired;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    public String getStaffJob() {
        return staffJob;
    }

    public void setStaffJob(String staffJob) {
        this.staffJob = staffJob;
    }

    public int getStaffID() {
        return staffID;
    }

    public void setStaffID(int staffID) {
        this.staffID = staffID;
    }

    @Override
    public void speak() {
        logger.info("Hello I'm a University Staff");
    }
}
