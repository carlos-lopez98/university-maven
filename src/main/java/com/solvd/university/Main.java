package com.solvd.university;

import com.solvd.university.database.StudentDatabase;
import com.solvd.university.database.UniversityDatabase;
import com.solvd.university.generation.Generate;
import com.solvd.university.generation.PrivateUniNames;
import com.solvd.university.generation.PublicUniNames;
import com.solvd.university.generation.SchoolFlag;
import com.solvd.university.models.EntryExamScore;
import com.solvd.university.models.persons.Student;
import com.solvd.university.models.universities.PrivateUniversity;
import com.solvd.university.models.universities.PublicUniversity;
import com.solvd.university.models.universities.University;
import com.solvd.university.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


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

        logger.info("Hi " + newAdmissionStudentOne.getFirstName() + " Please input your reading, writing and math scores");
        logger.info("To see what schools you qaulify for");

        //Imitating Student Input
        logger.info("***EMULATED INPUT***");
        logger.info("90, 98, 90");
        newAdmissionStudentOne.setMathScore(90);
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


        List<Student> students = universityDatabase.getUniversityList().stream()
                .flatMap(universities -> {
                    return universities.getStudents().stream();
                }).collect(Collectors.toList());

        return students;
    }


    //Uses Reflection API
    private static List<University> getUniversities() {
        List<University> universityList = new ArrayList<>();

        try {
            Class<?> publicUniClass = Class.forName("com.solvd.university.models.universities.PublicUniversity");
            Class<?> privateUniClass = Class.forName("com.solvd.university.models.universities.PrivateUniversity");

            for (int i = 0; i < 5; i++) {
                String publicUniName = PublicUniNames.values()[i % PublicUniNames.values().length].getSchoolName();
                boolean publicUniFlag = SchoolFlag.returnRandomFlag().getFlag();

                //Uses Reflection
                University publicUni = (University) publicUniClass.getConstructor(String.class, List.class, List.class, boolean.class)
                        .newInstance(publicUniName, Generate.generateCourseList(), Generate.generateDepartmentList(), publicUniFlag);
                publicUni.setStudents(new ArrayList<Student>());
                universityList.add(publicUni);

                String privateUniName = PrivateUniNames.values()[i % PrivateUniNames.values().length].getSchoolName();
                boolean privateUniFlag = SchoolFlag.returnRandomFlag().getFlag();

                //Uses Reflection
                University privateUni = (University) privateUniClass.getConstructor(String.class, List.class, List.class, boolean.class)
                        .newInstance(privateUniName, Generate.generateCourseList(), Generate.generateDepartmentList(), privateUniFlag);

                privateUni.setStudents(new ArrayList<Student>());

                universityList.add(privateUni);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return universityList;
    }

    /*private static List<University> getUniversities() {

        List<University> universityList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            universityList.add(Generate.generatePublicUni(i));
            universityList.add(Generate.generatePrivateUni(i));
        }

        return universityList;
    }*/

    private static void printUniversitiesInSystem() {

        IntStream.range(0, universityDatabase.getUniversityList().size())
                .mapToObj(i -> (i + 1) + ": " + universityDatabase.getUniversityList().get(i).getUniversityName())
                .forEachOrdered(System.out::println);

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

}
