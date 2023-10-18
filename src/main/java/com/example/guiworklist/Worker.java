package com.example.guiworklist;

public class Worker {

    String firstName;
    String surname;
    String position;
    int age;
    int workExperience;
    double salary;
    double savings;

    public Worker(String firstName, String surname,
                  String position, int age, int workExperience) throws ExcFormatField, MineException {
        if (firstName == null || surname == null || position == null || workExperience == 0 || age == 0) {
            throw new MineException();
        }
        if (age < 18) {
            throw new ExcFormatField(workExperience);
        }
        if (workExperience > age) {
            throw new ExcFormatField(workExperience);
        }

        this.firstName = firstName;
        this.surname = surname;
        this.position = position;
        this.age = age;
        this.workExperience = workExperience;
    }

//    public Worker(String firstName, String surname, String position,
//                  int age, int workExperience, double salary, double savings) {
//        this.firstName = firstName;
//        this.surname = surname;
//        this.position = position;
//        this.age = age;
//        this.workExperience = workExperience;
//        this.salary = salary;
//        this.savings = savings;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(int workExperience) {
        this.workExperience = workExperience;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }

    @Override
    public String toString() {
        return firstName +
               " " + surname +
               ", " + age +
               ", " + workExperience +
               ", " + position;
    }
}
