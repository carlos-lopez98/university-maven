package com.solvd.university.models.universities;

import com.solvd.university.models.courses.Course;
import com.solvd.university.models.departments.Department;
import com.solvd.university.models.persons.Staff;
import com.solvd.university.models.persons.Student;

import java.util.List;

public abstract class University {

    private List<Course> courses;
    private List<Department> departments;
    private List<Student> students;
    private List<Staff> personnel;
    private String universityName;


    public University(String universityName, List<Course> courses, List<Department> departments) {
        this.universityName = universityName;
        this.courses = courses;
        this.departments = departments;
    }

    //Abstract Method
    public abstract void displayCoursesOffered();

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Staff> getPersonnel() {
        return personnel;
    }

    public void setPersonnel(List<Staff> personnel) {
        this.personnel = personnel;
    }
}
