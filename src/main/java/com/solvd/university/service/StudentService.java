package com.solvd.university.service;

import com.solvd.university.database.StudentDatabase;
import com.solvd.university.database.UniversityDatabase;
import com.solvd.university.exceptions.UniversityNotFoundException;
import com.solvd.university.models.persons.Student;
import com.solvd.university.models.universities.University;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class StudentService {

    private UniversityDatabase universityDatabase;
    private StudentDatabase studentDatabase;

    //Initializing our values to mess with
    public StudentService(StudentDatabase studentDatabase, UniversityDatabase universityDatabase){
        this.universityDatabase = universityDatabase;
        this.studentDatabase = studentDatabase;
    }

    public void enrollToUniversity(Student student, String universityEnrolling){
        //Null Check -- Using JDK Interface
        BiPredicate<Student, String> nullCheck = (stu, str) -> str == null || stu == null;

        if(nullCheck.test(student, universityEnrolling)){
            throw new NullPointerException("The information entered is empty");
        }

        //Jdk Interface - Stream API
       List<String> universityNames = universityDatabase
               .getUniversityList()
               .stream()
               .map( (uni) -> uni.getUniversityName())
               .collect(Collectors.toList());

        for(String university: universityNames){
            if(universityEnrolling.equalsIgnoreCase(university)){
                student.setUniAssigned(universityEnrolling);
                universityDatabase.addStudentToUniversityStudentList(student, universityEnrolling);
                studentDatabase.addStudent(student);
            }else{
                throw new UniversityNotFoundException("Could not find that university in Database");
            }
        }


    }




    //TODO add a Generate Clubs to Generate Class
    public void enrollToClub(Student student, String universityName, String clubName){

        List<University> universities = universityDatabase.getUniversityList();

        for(University uni: universities){
            if(uni.getUniversityName().equalsIgnoreCase(universityName)){

            }
        }

    }
}
