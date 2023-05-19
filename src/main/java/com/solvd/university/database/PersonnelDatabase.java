package com.solvd.university.database;

import com.solvd.university.Main;
import com.solvd.university.exceptions.StudentNotFoundException;
import com.solvd.university.models.persons.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class PersonnelDatabase {

    private Logger logger = LogManager.getLogger(Main.class);
    private List<Staff> personnel;

    //Initializes our database to be the personnel created from the generate university methods
    public PersonnelDatabase(List<Staff> personnel) {

        this.personnel = personnel;
    }

    private void addPersonnel(Staff person) {
        personnel.add(person);
        logger.info("Staff person was successfully added");
    }

    private void deleteByID(int staffId) {
        boolean inStream = personnel.stream()
                .anyMatch(person -> person.getStaffID() == staffId);

        if (inStream) {
            this.personnel = personnel.stream()
                    .filter((person) -> person.getStaffID() != staffId)
                    .collect(Collectors.toList());
        } else {
            throw new StudentNotFoundException("Staff Id was not found in Personnel Database");
        }
    }
}
