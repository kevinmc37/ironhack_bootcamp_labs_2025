package classes;

public class Intern extends Employee {
    private int duration; // In days, time the intern will work for the company
    private final double SALARY_LIMIT = 20000; // Interns can't have a higher salary

    // Constructor, inherits everything from Employee, except the duration
    public Intern(String name, int age, String position, double salary, int duration) {
        super(name, age, position, salary);
        setDuration(duration);
    }

    // Getter
    public int getDuration() {
        return duration;
    }

    // Setters
    public void setDuration(int newDuration) {
        if (!this.getPosition().equals("INTERN")) {
            // If for any reason position is not intern that means this intern employee is not valid
            this.duration = 0;
        }
        else {
            if (newDuration < 30 || newDuration > 365) { // Minimum and maximum days for an intern
                this.duration = 30;
            }
            else {
                this.duration = newDuration;
            }
        }
    }

    // We add a salary limit for interns so we override the setSalary method of the parent to check for that
    @Override
    public void setSalary(double newSalary) {
        if (newSalary < 1000 || newSalary > SALARY_LIMIT) { // Range of valid salaries for intern employees
            super.setSalary(SALARY_LIMIT); // We call the setSalary method of the parent to add the salary value
        }
        else {
            super.setSalary(newSalary); // Same as above, as salary is a private property from the parent
        }
    }
}
