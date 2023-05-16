package com.solvd.university.generation;

import com.solvd.university.models.courses.Calculus;
import com.solvd.university.models.courses.Chemistry;
import com.solvd.university.models.courses.Course;
import com.solvd.university.models.courses.Literature;
import com.solvd.university.models.departments.Department;
import com.solvd.university.models.departments.EngineeringDep;
import com.solvd.university.models.departments.EnglishDep;
import com.solvd.university.models.departments.ScienceDep;
import com.solvd.university.models.persons.Student;
import com.solvd.university.models.universities.PublicUniversity;
import com.solvd.university.models.universities.University;

import java.util.ArrayList;
import java.util.List;

/*
 *
 * Generates initial values for testing purposes in main class
 *
 */

public final class Generate {

    //Generates Random Public School
    public static University generatePublicUni(int i) {

        String uniName = PublicUniNames.values()[i].getSchoolName();

        University university = new PublicUniversity(uniName, generateCourseList(), generateDepartmentList(),
                SchoolFlag.returnRandomFlag().getFlag());

        university.setStudents(generatePublicUniStudentList(uniName));
        return university;
    }

    //Generates Random Private School
    public static University generatePrivateUni(int j) {

        String uniName = PrivateUniNames.values()[j].getSchoolName();

        University university = new PublicUniversity(uniName, generateCourseList(), generateDepartmentList(),
                SchoolFlag.returnRandomFlag().getFlag());

        university.setStudents(generatePrivateUniStudentList(uniName));

        return university;
    }

    //TODO Refactor to provide correct ID per school, instead of per student, IDs should correspond to school
    public static List<Student> generatePrivateUniStudentList(String privateUniToAssign) {

        List<Student> students = new ArrayList<>();
        String uniAssigned = privateUniToAssign;

        for (int i = 0; i < 5; i++) {
            int randoIndex = (int) Math.random() * FirstNames.values().length;
            String studentFirstName = FirstNames.values()[randoIndex].toString();
            String lastName = LastNames.values()[randoIndex].toString();

            Student student = new Student(studentFirstName, lastName, uniAssigned);

            student.setStudentId(i);

            students.add(student);
        }
        return students;
    }

    //TODO Refactor to provide correct ID per school, instead of per student, IDs should correspond to school
    public static List<Student> generatePublicUniStudentList(String publicUniToAssign) {

        List<Student> students = new ArrayList<>();
        String uniAssigned = publicUniToAssign;

        for (int i = 0; i < 5; i++) {
            int randoIndex = (int) Math.random() * FirstNames.values().length;
            String studentFirstName = FirstNames.values()[randoIndex].toString();
            String lastName = LastNames.values()[randoIndex].toString();

            Student student = new Student(studentFirstName, lastName, uniAssigned);
            student.setStudentId(i);
            students.add(student);
        }
        return students;
    }

    public static List<Course> generateCourseList() {

        List<Course> courses = new ArrayList<>() {
            {
                add(generateLiterature());
                add(generateCalcCourse());
                add(generateChemistry());
            }
        };

        return courses;
    }

    public static List<Department> generateDepartmentList() {
        List<Department> departments = new ArrayList<>() {
            {
                add(generateEnglishDep());
                add(generateEngineeringDepartment());
                add(generateScienceDep());
            }
        };
        return departments;
    }

    private static Department generateEngineeringDepartment() {

        Department engineering = new EngineeringDep("Engineering Department");

        return engineering;
    }

    private static Department generateEnglishDep() {
        Department english = new EnglishDep("English Department");

        return english;
    }

    private static Department generateScienceDep() {
        Department science = new ScienceDep("Science Department");

        return science;
    }

    private static Course generateCalcCourse() {
        Course calculus = new Calculus("Calculus");
        return calculus;
    }

    private static Course generateChemistry() {
        Course chemistry = new Chemistry("Chemistry");
        return chemistry;
    }

    private static Course generateLiterature() {
        Course literature = new Literature("Literature");
        return literature;
    }

}
