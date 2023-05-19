package com.solvd.university.models.courses;

import com.solvd.university.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculus extends Course implements Enroll {

    private Logger logger = LogManager.getLogger(Main.class);
    private String groupsAssigned;

    @Override
    public void booksNeeded() {
        logger.info("Calculus Volume 1 by Morris Kline");
    }

    public Calculus(String courseName) {
        super.setCourseName(courseName);
    }

    @Override
    public void addClassToSchedule() {
        logger.info("Calculus has been added to your schedule");
    }

    public String getGroupsAssigned() {
        return groupsAssigned;
    }

    public void setGroupsAssigned(String groupsAssigned) {
        this.groupsAssigned = groupsAssigned;
    }
}
