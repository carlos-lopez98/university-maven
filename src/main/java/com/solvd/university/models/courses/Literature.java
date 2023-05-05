package com.solvd.university.models.courses;

public class Literature extends Course implements Enroll {

    private String essaysNeeded;

    public Literature(String courseName) {
        super.setCourseName(courseName);
    }


    @Override
    public void booksNeeded() {
        System.out.println("College Language and Literature by Renee H. Shea");
    }

    @Override
    public void addClassToSchedule() {
        System.out.println("Literature has been added to your schedule");
    }

    public String getEssaysNeeded() {
        return essaysNeeded;
    }

    public void setEssaysNeeded(String essaysNeeded) {
        this.essaysNeeded = essaysNeeded;
    }
}

