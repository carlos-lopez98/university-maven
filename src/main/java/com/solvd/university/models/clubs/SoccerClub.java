package com.solvd.university.models.clubs;

import com.solvd.university.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SoccerClub extends Club implements Activity{
    private Logger logger = LogManager.getLogger(Main.class);

    private String teamName;

    public SoccerClub(String clubName, String meetingTimes) {
        super(clubName, meetingTimes);
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    //Abstract Override
    @Override
    public void displayActivity() {
        logger.info("We will be playing in teams of 7 per team, and we will participate in local leagues");
    }

    @Override
    public void doActivity() {
        logger.info("Soccer Club is now in session");
    }
}
