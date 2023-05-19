package com.solvd.university.models.departments;

import com.solvd.university.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class EnglishDep extends Department implements Budget {

    private Logger logger = LogManager.getLogger(Main.class);


    private List<String> booksInLibrary;

    public EnglishDep(String departmentTeamName) {
        super(departmentTeamName);
    }

    @Override
    public void seeDepartmentTutoringHours() {
        logger.info("Hours: M-F 9AM - 11AM");
    }

    @Override
    public void showBudget() {
        logger.info("This Semester's Budget for the English Department is $100,000");
    }

    public List<String> getBooksInLibrary() {
        return booksInLibrary;
    }

    public void setBooksInLibrary(List<String> booksInLibrary) {
        this.booksInLibrary = booksInLibrary;
    }
}
