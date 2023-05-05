package com.solvd.university.database;

import com.solvd.university.Main;
import com.solvd.university.exceptions.StudentNotFoundException;
import com.solvd.university.models.persons.Staff;
import com.solvd.university.models.universities.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PersonnelDatabase {

    private Logger logger = LogManager.getLogger(Main.class);
    private List<Staff> personnel;

    //Initializes our database to be the personnel created from the generate university methods
    //TODO refactor for re-usability
    public PersonnelDatabase(UniversityDatabase database) {
        int counter = 0;


        for (University university : database.getUniversityList()) {
            personnel.addAll(database.getUniversityList().get(counter).getPersonnel());
        }
    }

    private void addPersonnel(Staff person) {
        personnel.add(person);
        logger.info("Student was successfully added");
        System.out.println("Student was succesfully added");
    }

    //TODO Remove Staffer from UniversityDatabase
    private void deleteByID(int staffId) {
        for (Staff person : personnel) {
            if (person.getStaffID() == staffId) {
                personnel.remove(person);
            } else {
                throw new StudentNotFoundException("Staff Id was not found in Personnel Database");
            }
        }
    }
}
