package com.solvd.university.models.clubs;

import com.solvd.university.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RoboticsClub extends Club implements Activity{

    private Logger logger = LogManager.getLogger(Main.class);

    private String clubRobotName;

    public RoboticsClub(String clubName, String meetingTimes) {
     super(clubName, meetingTimes);
    }

    public String getClubRobotName() {
        return clubRobotName;
    }

    public void setClubRobotName(String clubRobotName) {
        this.clubRobotName = clubRobotName;
    }

    //Abstract Override
    @Override
    public void displayActivity() {
        logger.info("We will be creating an underwater robot this semester");
    }

    @Override
    public void doActivity() {
        logger.info("Robotics Club is now in session");
    }
}
