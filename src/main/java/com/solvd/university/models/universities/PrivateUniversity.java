package com.solvd.university.models.universities;

import com.solvd.university.models.courses.Course;
import com.solvd.university.models.departments.Department;

import java.util.List;

public class PrivateUniversity extends University implements UniversityHours {

    private int tuitionCost;
    private int dormCost;
    private boolean inState;

    private final  int EntryExamScoreNeeded = 92;

    public PrivateUniversity(String universityName, List<Course> courses, List<Department> departments, boolean inState) {
        super(universityName, courses, departments);

        this.inState = inState;

        if (!this.inState) {
            this.tuitionCost = 16000;
            this.dormCost = 25000;
        } else {
            this.tuitionCost = 9000;
            this.dormCost = 12500;
        }
    }

    //Static
    public  void showEntryExamScoreNeeded() {
        System.out.println("Score needed for entry: " + EntryExamScoreNeeded);
    }

    public int getTuitionCost() {
        return tuitionCost;
    }

    public int getDormCost() {
        return dormCost;
    }

    public boolean isInState() {
        return inState;
    }

    @Override
    public void displayCoursesOffered() {

        System.out.println(this.getUniversityName() + "Offers the below courses");

        for (Course course : this.getCourses()) {
            System.out.println(course.getCourseName());
        }
    }

    @Override
    public void displayAdmissionOfficeHours() {
        System.out.printf("University is open from 8AM - 5PM M-F");
    }

    public int getEntryExamScoreNeeded() {
        return EntryExamScoreNeeded;
    }
}
