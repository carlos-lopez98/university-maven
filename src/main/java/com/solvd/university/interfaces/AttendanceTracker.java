package com.solvd.university.interfaces;

import com.solvd.university.models.persons.Student;

/*
*
* Will be used for the professor role
*
*/

public interface AttendanceTracker {
    void trackAttendance(Student student);
}
