package com.solvd.university.models.clubs;

import com.solvd.university.models.persons.Student;

import java.util.List;

public abstract class Club {

    private String clubName;
    private List<Student> members;
    private String meetingTimes;

    public Club(String clubName, String meetingTimes){
        this.clubName = clubName;
        this.meetingTimes = meetingTimes;
    }

    //Abstract Method
    public abstract void displayActivity();

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public List<Student> getMembers() {
        return members;
    }

    public void setMembers(List<Student> members) {
        this.members = members;
    }

    public String getMeetingTimes() {
        return meetingTimes;
    }

    public void setMeetingTimes(String meetingTimes) {
        this.meetingTimes = meetingTimes;
    }
}
