package ru.bmixdev.model;

public class Employee {
    private String lastName;
    private String middleName;
    private String firstName;
    private String position;
    private String email;
    private int age;
    private double salary;

    public Employee(String lastName, String middleName, String firstName, String position, String email, int age, double salary) {
        this.lastName = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.position = position;
        this.email = email;
        this.age = age;
        this.salary = salary;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public void printInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.position)
                .append(" ")
                .append(this.lastName)
                .append(" ")
                .append(this.middleName)
                .append(" ")
                .append(firstName)
                .append(" ")
                .append(this.email);
        System.out.println(sb);
    }
}
