package com.solvd.university.database;

import com.solvd.university.Main;
import com.solvd.university.exceptions.StudentNotFoundException;
import com.solvd.university.models.persons.Student;
import com.solvd.university.models.universities.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.stream.Collectors;

public class StudentDatabase {

    private Logger logger = LogManager.getLogger(Main.class);
    private List<Student> students;

    public StudentDatabase() {
    }

    public StudentDatabase(List<Student> students) {
        this.students = students;

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
        logger.info("Student was successfully added");
    }

    private void deleteByID(int studentId) {

        boolean inStream = students.stream()
                .anyMatch(student -> student.getStudentId() == studentId);

        if (inStream) {
            this.students = students.stream()
                    .filter(student -> student.getStudentId() != studentId)
                    .collect(Collectors.toList());
        } else {
            throw new StudentNotFoundException("Student Id was not found in Student Database");
        }

    }
}
