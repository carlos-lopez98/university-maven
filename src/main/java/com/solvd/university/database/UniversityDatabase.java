package com.solvd.university.database;

import com.solvd.university.generation.Generate;
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

public class UniversityDatabase {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private List<University> universityList = new ArrayList<>();

    //TODO refactor for re-usability
    public UniversityDatabase(List<University> universitiesAvailable) {

       this.universityList = universitiesAvailable;
    }

    public void save(University university) {
        universityList.add(university);
    }

    public void delete(University university) {

        for (int j = 0; j < universityList.size(); j++) {

            try {
                if (universityList.get(j).getUniversityName() == university.getUniversityName()) {
                    universityList.remove(universityList.get(j));
                } else {
                    throw new UniversityNotFoundException("University Not Found In DataBase to Delete");
                }
            } catch (UniversityNotFoundException e) {
                logger.info("Exception message = " + e);
            }
        }

    }

    public void addStudentToUniversityStudentList(Student student, String university) {

        for (University uni : this.getUniversityList()) {
            if (uni.getUniversityName().equalsIgnoreCase(university)) {
                uni.getStudents().add(student);
            } else {
                throw new UniversityNotFoundException("University not found, while trying to add student to a particular university");
            }
        }
    }

    public List<University> getUniversityList() {
        return universityList;
    }

    public University getByUniversityName(String name) {
        List<University> universities = this.getUniversityList();

        for (University university : universities) {

            if (university.getUniversityName().equalsIgnoreCase(name)) {
                return university;
            } else {
                throw new UniversityNotFoundException("No such university in database");
            }
        }

        return null;
    }

    public void setUniversityList(List<University> universityList) {
        this.universityList = universityList;
    }


    public Course getAllCourses(String universityName) {

        if (universityName == null) {
            throw new NullPointerException();
        }

        List<Course> courses = null;

        for (University university : this.getUniversityList()) {
            if (universityName.equalsIgnoreCase(universityName)) {
                courses.addAll(university.getCourses());
            } else {
                throw new CourseNotFoundException("Could not find any courses for " + universityName);
            }
        }

        return (Course) courses;
    }

    public List<Staff> getAllStaffByUniversity(String universityName) {

        for (University university : this.getUniversityList()) {
            if (university.getUniversityName().equalsIgnoreCase(universityName)) {

                return university.getPersonnel();
            } else {
                throw new PersonnelNotFoundException("Could not find any personnel pertaining to " + universityName);
            }
        }

        return null;
    }
};
