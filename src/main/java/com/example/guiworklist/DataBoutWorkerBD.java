package com.example.guiworklist;

public class DataBoutWorkerBD extends Worker{

    double salary;

    double savings;

    public DataBoutWorkerBD(String firstName, String surname, String position, int age, int workExperience, double salary, double savings) throws ExcFormatField, MineException {
        super(firstName, surname, position, age, workExperience);
        this.salary = salary;
        this.savings = savings;
    }



}
