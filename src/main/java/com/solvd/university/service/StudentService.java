package com.solvd.university.service;

import com.solvd.university.Main;
import com.solvd.university.database.StudentDatabase;
import com.solvd.university.database.UniversityDatabase;
import com.solvd.university.exceptions.UniversityNotFoundException;
import com.solvd.university.interfaces.StudentNotification;
import com.solvd.university.models.persons.Student;
import com.solvd.university.models.universities.University;

import org.apache.logging.log4j.LogManager;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class StudentService {

    private UniversityDatabase universityDatabase;
    private StudentDatabase studentDatabase;
    private static final org.apache.logging.log4j.Logger logger;

    static {
        logger = LogManager.getLogger(Main.class);
    }

    public StudentService() {
    }

    public void enrollToUniversity(Student student, String universityEnrolling) {
        //Null Check -- Using JDK Interface
        BiPredicate<Student, String> nullCheck = (stu, str) -> str == null || stu == null;

        if (nullCheck.test(student, universityEnrolling)) {
            throw new NullPointerException("The information entered is empty");
        }

        //Jdk Interface - Stream API
        List<String> universityNames = universityDatabase
                .getUniversityList()
                .stream()
                .map((uni) -> uni.getUniversityName())
                .collect(Collectors.toList());

        //Stream API - Replaces For Loop
        universityNames.stream()
                .filter(university -> university.equalsIgnoreCase(universityEnrolling))
                .findFirst()
                .ifPresentOrElse(
                        university -> {
                            student.setUniAssigned(universityEnrolling);
                            universityDatabase.addStudentToUniversityStudentList(student, universityEnrolling);
                            studentDatabase.addStudent(student);
                        },
                        () -> {
                            throw new UniversityNotFoundException("Could not find that university in Database");
                        }
                );

        //Sending Notification email using functional interface
        if(student.getEmail() != null){
            StudentNotification notification = (studentEmail, message) -> {
                logger.info("Email sent to " + studentEmail);
                logger.info(message);
            };

            notification.sendEmail(student.getEmail(), "Student has been enrolled to " + universityEnrolling);
        }

    }


    //TODO add a Generate Clubs to Generate Class
    public void enrollToClub(Student student, String universityName, String clubName) {

        List<University> universities = universityDatabase.getUniversityList();

        for (University uni : universities) {
            if (uni.getUniversityName().equalsIgnoreCase(universityName)) {

            }
        }

    }

    public void setUniversityDatabase(UniversityDatabase universityDatabase) {
        this.universityDatabase = universityDatabase;
    }

    public void setStudentDatabase(StudentDatabase studentDatabase) {
        this.studentDatabase = studentDatabase;
    }

}
