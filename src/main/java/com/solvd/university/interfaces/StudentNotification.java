package com.solvd.university.interfaces;

/*
*
* Will be used as behavior to send email to students for significant milestones in their student journey
*
*/

public interface StudentNotification {
    void sendEmail(String studentEmail, String message);
}
