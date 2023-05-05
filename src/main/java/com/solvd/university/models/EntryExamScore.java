package com.solvd.university.models;

import com.solvd.university.models.persons.Student;

public  class EntryExamScore {



    //Calculates Score for entry
    public static int calculateEntryExamScore(Student student) {
        return (student.getMathScore() + student.getReadingScore() + student.getWritingScore()) / 3;
    }
}
