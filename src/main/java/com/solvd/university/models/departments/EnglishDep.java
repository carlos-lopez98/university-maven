package com.solvd.university.models.departments;

import java.util.List;

public class EnglishDep extends Department implements Budget {

    private List<String> booksInLibrary;

    public EnglishDep(String departmentTeamName) {
        super(departmentTeamName);
    }

    @Override
    public void seeDepartmentTutoringHours() {
        System.out.println("Hours: M-F 9AM - 11AM");
    }

    @Override
    public void showBudget() {
        System.out.println("This Semester's Budget for the English Department is $100,000");
    }

    public List<String> getBooksInLibrary() {
        return booksInLibrary;
    }

    public void setBooksInLibrary(List<String> booksInLibrary) {
        this.booksInLibrary = booksInLibrary;
    }
}
