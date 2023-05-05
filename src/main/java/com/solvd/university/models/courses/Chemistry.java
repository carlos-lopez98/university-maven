package com.solvd.university.models.courses;

public class Chemistry extends Course implements Enroll {

    private String equipmentNeeded;

    public Chemistry(String courseName) {
        super.setCourseName(courseName);
    }

    @Override
    public void booksNeeded() {
        System.out.println("Chemistry by Steven Zumdahl");
    }

    @Override
    public void addClassToSchedule() {
        System.out.println("Chemistry has been added to your schedule");
    }

    public String getEquipmentNeeded() {
        return equipmentNeeded;
    }

    public void setEquipmentNeeded(String equipmentNeeded) {
        this.equipmentNeeded = equipmentNeeded;
    }
}
