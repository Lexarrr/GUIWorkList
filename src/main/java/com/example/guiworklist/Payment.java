package com.example.guiworklist;

public class Payment {

    double salary;

    double savings;

    public Payment(double salary, double savings) {
        this.salary = salary;
        this.savings = savings;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "salary=" + salary +
                ", savings=" + savings +
                '}';
    }
}
