package com.solvd.university.models.courses;

import com.solvd.university.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Literature extends Course implements Enroll {

    private Logger logger = LogManager.getLogger(Main.class);

    private String essaysNeeded;

    public Literature(String courseName) {
        super.setCourseName(courseName);
    }


    @Override
    public void booksNeeded() {
        logger.info("College Language and Literature by Renee H. Shea");
    }

    @Override
    public void addClassToSchedule() {
        logger.info("Literature has been added to your schedule");
    }

    public String getEssaysNeeded() {
        return essaysNeeded;
    }

    public void setEssaysNeeded(String essaysNeeded) {
        this.essaysNeeded = essaysNeeded;
    }
}

