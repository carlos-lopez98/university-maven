package com.solvd.university.service;

import com.solvd.university.database.StudentDatabase;
import com.solvd.university.database.UniversityDatabase;
import com.solvd.university.models.persons.Staff;

import java.util.List;


public class AdminService {

    private StudentDatabase students;
    private UniversityDatabase universityDatabase;

    public AdminService(StudentDatabase students, UniversityDatabase universityDatabase){

        this.students = students;
        this.universityDatabase = universityDatabase;
    }


    public List<Staff> getAllStaffByUniversity(String universityName){
        return universityDatabase.getAllStaffByUniversity(universityName);
    }
}
