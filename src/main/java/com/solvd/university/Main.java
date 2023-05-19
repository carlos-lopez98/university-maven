package com.solvd.university;

import com.solvd.university.database.StudentDatabase;
import com.solvd.university.database.UniversityDatabase;
import com.solvd.university.generation.Generate;
import com.solvd.university.models.EntryExamScore;
import com.solvd.university.models.persons.Student;
import com.solvd.university.models.universities.PrivateUniversity;
import com.solvd.university.models.universities.PublicUniversity;
import com.solvd.university.models.universities.University;
import com.solvd.university.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private static UniversityDatabase universityDatabase = new UniversityDatabase();
    private static StudentDatabase studentDatabase = new StudentDatabase();
    private static StudentService studentService = new StudentService();

    public static void main(String[] args) {

        //Generate Ten Universities for the Database
        universityDatabase.setUniversityList(getUniversities());

        //Pulls all students from the university database
        studentDatabase.setStudents(getStudents());

        //Giving our service databases to access
        studentService.setStudentDatabase(studentDatabase);
        studentService.setUniversityDatabase(universityDatabase);

        //Emulates Student receiving information about what university they qualify for
        logger.info("********Hello, Welcome to our University system********");
        logger.info("*******************************************************");
        logger.info("Our Current System has the below Universities Available for Review");
        printUniversitiesInSystem();

        Student newAdmissionStudentOne = new Student("John", "Luke", null);
        Student newAdmissionStudentTwo = new Student("Mary", "Adams", null);

        logger.info("Hi " + newAdmissionStudentOne.getFirstName() + "Please input your reading, writing and math scores");
        logger.info("To see what schools you qaulify for");

        //Imitating Student Input
        newAdmissionStudentOne.setMathScore(55);
        newAdmissionStudentOne.setReadingScore(98);
        newAdmissionStudentOne.setWritingScore(90);

        logger.info("Your calculated entry score is " + EntryExamScore.calculateEntryExamScore(newAdmissionStudentOne));
        logger.info("Your qualifying schools are: ");
        printQualifiedSchools(newAdmissionStudentOne);

        logger.info("Please select from below options: ");
        logger.info("1: Browse Universities on file");


        //Emulate Student enrolling in University
        Student studentToEnroll = new Student("Bobby", "Lee", null);
        studentService.enrollToUniversity(studentToEnroll, "Stanford");

        //Emulates Student Asking for Courses available by University
        logger.info(String.valueOf(universityDatabase.getAllCourses("Stanford")));

    }

    private static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();
        for (University university : universityDatabase.getUniversityList()) {
            students.addAll(university.getStudents());
        }
        return students;
    }

    private static List<University> getUniversities() {
        List<University> universityList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            universityList.add(Generate.generatePublicUni(i));
            universityList.add(Generate.generatePrivateUni(i));
        }
        return universityList;
    }

    private static void printUniversitiesInSystem() {
/*
        int counter = 1;
*/
        //Refactor to return currect position values, currently puts 0 for everything
        universityDatabase.getUniversityList().stream()
                .map(University::getUniversityName)
                .forEachOrdered((universityName) -> {
                    int counter = universityDatabase.getUniversityList().indexOf(universityName) + 1;
                    logger.info(counter + ": " + universityName);
                });

     /*   for (University university : universityDatabase.getUniversityList()) {
            logger.info(counter + ": " + university.getUniversityName());
            counter++;
        }*/
    }

    private static void printQualifiedSchools(Student student) {

        int counter = 1;


        for (University university : universityDatabase.getUniversityList()) {

            if (university.getClass() == PrivateUniversity.class) {
                university = new PrivateUniversity(university.getUniversityName(), university.getCourses(),
                        university.getDepartments(), ((PrivateUniversity) university).isInState());
                if (((PrivateUniversity) university).getEntryExamScoreNeeded() < EntryExamScore.calculateEntryExamScore(student)) {
                    logger.info(counter + ": " + university.getUniversityName());
                    counter++;
                }
            } else if (university.getClass() == PublicUniversity.class) {
                university = new PublicUniversity(university.getUniversityName(), university.getCourses(),
                        university.getDepartments(), ((PublicUniversity) university).isInState());
                if (((PublicUniversity) university).getEntryExamScoreRequirement() < EntryExamScore.calculateEntryExamScore(student)) {
                    logger.info(counter + ": " + university.getUniversityName());
                    counter++;
                }
            }
        }
    }

    //TODO
    //Emulate Student Enrolling in class
    //Emulates Student adding Course to Curriculum
    //Emulate AdminService Retrieving all Personnel
    //Emulate Admin adding and removing courses from a university
}
