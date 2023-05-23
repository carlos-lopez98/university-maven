package com.solvd.university.database;

import com.solvd.university.Main;
import com.solvd.university.exceptions.CourseNotFoundException;
import com.solvd.university.exceptions.PersonnelNotFoundException;
import com.solvd.university.exceptions.UniversityNotFoundException;
import com.solvd.university.models.courses.Course;
import com.solvd.university.models.persons.Staff;
import com.solvd.university.models.persons.Student;
import com.solvd.university.models.universities.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UniversityDatabase {

    private static final Logger logger = LogManager.getLogger(Main.class);
    private List<University> universityList = new ArrayList<>();

    public UniversityDatabase() {
    }

    ;

    public UniversityDatabase(List<University> universitiesAvailable) {

        this.universityList = universitiesAvailable;
    }

    public void save(University university) {
        universityList.add(university);
    }

    public void delete(University university) {

        universityList.stream()
                .filter(u -> u.getUniversityName().equalsIgnoreCase(university.getUniversityName()))
                .findFirst()
                .ifPresentOrElse(
                        u -> universityList.remove(u),
                        () -> {
                            throw new UniversityNotFoundException("University not found in Database to Delete");
                        }
                );

    }

    public void addStudentToUniversityStudentList(Student student, String university) {


        universityList.stream()
                .filter(u -> u.getUniversityName().equalsIgnoreCase(university))
                .findFirst()
                .ifPresentOrElse(
                        u -> u.getStudents().add(student),
                        () -> {
                            throw new UniversityNotFoundException("University not found, while trying to add student to that particular school");
                        }
                );

    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public University getByUniversityName(String name) {

        University foundUni = universityList.stream()
                .filter(u -> u.getUniversityName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new UniversityNotFoundException("No such university in database"));

        return foundUni;

    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }


    public List<Course> getAllCourses(String universityName) {

        if (universityName == null) {
            throw new NullPointerException();
        }

        List<Course> courses = universityList.stream()
                .filter(u -> u.getUniversityName().equalsIgnoreCase(universityName))
                .flatMap(u -> u.getCourses().stream())
                .collect(Collectors.toList());

        if (courses.isEmpty()) {
            throw new CourseNotFoundException("Could not find any courses for " + universityName);
        }

        return courses;
    }

    public List<Staff> getAllStaffByUniversity(String universityName) {

        List<Staff> personnel = universityList.stream()
                .filter(u -> u.getUniversityName().equalsIgnoreCase(universityName))
                .flatMap(u -> u.getPersonnel().stream())
                .collect(Collectors.toList());

        if(personnel.isEmpty()){
            throw new PersonnelNotFoundException("Could not find any personnel pertaining to " + universityName);
        }

        return personnel;
    }
};
