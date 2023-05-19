package com.solvd.university.models.persons;

import com.solvd.university.Main;
import com.solvd.university.exceptions.InvalidScoreException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Student extends Person implements Speak {

    private Logger logger = LogManager.getLogger(Main.class);

    private int studentId;
    private int mathScore;
    private int readingScore;
    private int writingScore;

    public Student(String firstName, String lastName, String uniAssigned) {
        super(firstName, lastName, uniAssigned);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getMathScore() {

        return mathScore;
    }

    public void setMathScore(int mathScore) {

        if (mathScore <= 100 && mathScore >= 0) {
            this.mathScore = mathScore;
        } else {
            throw new InvalidScoreException("The Score entered must be between 0 and 100");
        }
    }

    public int getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(int readingScore) {

        if (readingScore <= 100 && readingScore >= 0) {
            this.readingScore = readingScore;
        } else {
            throw new InvalidScoreException("Score must be between 0 and 100");
        }
    }

    public int getWritingScore() {
        return writingScore;
    }

    public void setWritingScore(int writingScore) {

        if (writingScore <= 100 && writingScore >= 0) {
            this.writingScore = writingScore;
        } else {
            throw new InvalidScoreException("Score must be between 0 and 100");
        }
    }

    @Override
    public void speak() {
        logger.info("Hello I'm a University Student");
    }
}
