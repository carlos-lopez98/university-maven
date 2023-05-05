package com.solvd.university;

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

//Generates information for the Databases to use
public final class Generate {

    private static final List<String> PublicUniversityNames = new ArrayList<>() {
        {
            add("Cal State Long Beach");
            add("Cal State San Diego");
            add("Cal State San Francisco");
            add("Cal State Fresno");
            add("CalTech");
        }
    };

    private static final List<String> PrivateUniversityNames = new ArrayList<>() {
        {
            add("Stanford");
            add("UCLA");
            add("University of the Pacific");
            add("USC");
            add("Santa Clara University");
        }
    };

    private static final List<Boolean> InStateOrOutOfState = new ArrayList<Boolean>() {
        {
            add(false);
            add(true);
        }
    };

    private static final List<String> FirstNames = new ArrayList<>() {
        {
            add("John");
            add("Michelle");
            add("Gerald");
            add("Carlos");
            add("Mary");
        }
    };
    
    private static final List<String> LastNames = new ArrayList<>() {
        {
            add("White");
            add("Smith");
            add("Doe");
            add("Prior");
            add("Felt");
        }
    };

    //Generates Random Public School
    public static University generatePublicUni(int i) {
        String uniName = PublicUniversityNames.get(i);

        University university = new PublicUniversity(uniName, generateCourseList(), generateDepartmentList(),
                InStateOrOutOfState.get((int) Math.random() * InStateOrOutOfState.size()));

        university.setStudents(generatePublicUniStudentList());
        return university;
    }

    //Generates Random Private School
    public static University generatePrivateUni(int j) {

        String uniName = PrivateUniversityNames.get(j);

        University university = new PublicUniversity(uniName, generateCourseList(), generateDepartmentList(),
                InStateOrOutOfState.get((int) Math.random() * InStateOrOutOfState.size()));

        university.setStudents(generatePrivateUniStudentList());

        return university;
    }

    public static List<Student> generatePrivateUniStudentList() {

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int randoIndex = (int) Math.random() * FirstNames.size();
            String studentFirstName = FirstNames.get(randoIndex);
            String lastName = LastNames.get(randoIndex);
            String uniAssigned = PrivateUniversityNames.get(randoIndex);
            Student student = new Student(studentFirstName, lastName, uniAssigned);

            student.setStudentId(i);

            students.add(student);
        }
        return students;
    }

    public static List<Student> generatePublicUniStudentList() {

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int randoIndex = (int) Math.random() * FirstNames.size();
            String studentFirstName = FirstNames.get(randoIndex);
            String lastName = LastNames.get(randoIndex);
            String uniAssigned = PublicUniversityNames.get(randoIndex);

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
