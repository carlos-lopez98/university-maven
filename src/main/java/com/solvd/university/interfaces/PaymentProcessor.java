package com.solvd.university.interfaces;

import com.solvd.university.models.persons.Student;

public interface PaymentProcessor {

    void processPayment(Student student, double amount);
}
