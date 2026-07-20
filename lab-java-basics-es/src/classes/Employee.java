package classes;

public class Employee {
    private String name;
    private int age;
    private String position; // CEO - MANAGER - SUPERVISOR - EMPLOYEE - INTERN - UNAVAILABLE
    private double salary;

    // Employee Constructor. Mandatory properties
    public Employee(String name, int age, String position, double salary) {
        setName(name);
        setPosition(position);
        setSalary(salary);
        setAge(age); // We set age the last so we can check for a valid position and salary
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setName(String newName) {
        this.name = newName.trim();
    }

    public void setAge(int newAge) {
        if (newAge < 18 || newAge > 70) { // Employee can't be a minor, neither be overworked after 70
            this.position = "UNAVAILABLE"; // Can't work under 18 or over 70 years old. No position
            this.salary = 0; // No salary until the employee meets the conditions
        }
        this.age = newAge;
    }

    public void setPosition(String newPosition) {
        if (this instanceof Intern) { // If employee is of class intern we don't need to check their position
            this.position = "INTERN"; // Interns are always of class Intern if they are valid employees
        }
        else if (newPosition.equals("CEO") || newPosition.equals("MANAGER") || newPosition.equals("SUPERVISOR")
        || newPosition.equals("EMPLOYEE")) {
            this.position = newPosition.trim();
        }
        else { // Undefined position or invalid employee
            this.position = "UNAVAILABLE";
            // todo check which is the reason of unavailability and try to solve it except if it's age.
        }
    }

    public void setSalary(double newSalary) {
        if (!(this instanceof Intern)) { // If the employee is an intern, we check the salary on the intern class
            if (newSalary < 5000) { // Minimum salary for normal employees
                this.salary = 5000;
            }
            else { // Valid salary for normal employee
                this.salary = newSalary;
            }
        }
        else { // Valid salary for interns
            this.salary = newSalary;
        }
    }
}
