package com.solvd.university.models.courses;

public abstract class Course {

    private String courseName;

    //Abstract Method
    public abstract void booksNeeded();

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
