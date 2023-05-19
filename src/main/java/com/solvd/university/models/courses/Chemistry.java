package com.solvd.university.models.courses;

import com.solvd.university.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Chemistry extends Course implements Enroll {

    private Logger logger = LogManager.getLogger(Main.class);

    private String equipmentNeeded;

    public Chemistry(String courseName) {
        super.setCourseName(courseName);
    }

    @Override
    public void booksNeeded() {
        logger.info("Chemistry by Steven Zumdahl");
    }

    @Override
    public void addClassToSchedule() {
        logger.info("Chemistry has been added to your schedule");
    }

    public String getEquipmentNeeded() {
        return equipmentNeeded;
    }

    public void setEquipmentNeeded(String equipmentNeeded) {
        this.equipmentNeeded = equipmentNeeded;
    }
}
