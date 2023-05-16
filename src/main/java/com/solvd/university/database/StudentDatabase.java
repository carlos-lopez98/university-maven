package com.solvd.university.database;

import com.solvd.university.Main;
import com.solvd.university.exceptions.StudentNotFoundException;
import com.solvd.university.models.persons.Student;
import com.solvd.university.models.universities.University;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StudentDatabase {

    private Logger logger = LogManager.getLogger(Main.class);
    private List<Student> students;

    //TODO refactor for re-usability
    public StudentDatabase(List<Student> students){
        this.students = students;

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        students.add(student);
        logger.info("Student was successfully added");
    }

    //TODO Remove student from UniversityDatabase
    private void deleteByID(int studentId){
        for(Student student: students){
            if(student.getStudentId() == studentId){
                students.remove(student);
            }else {
                throw new StudentNotFoundException("Student Id was not found in Student Database");
            }
        }
    }
}
