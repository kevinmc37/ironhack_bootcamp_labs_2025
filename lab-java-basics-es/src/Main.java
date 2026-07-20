import classes.Employee;
import classes.Intern;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.addAll(List.of(1, 5, 7, -3, -50, 0, 386, 57, 8, 20, -61, 6));
        System.out.println("-------------DIFFERENCE BETWEEN VALUES-------------");
        int difference = differenceBetweenValues(intList);
        System.out.println("The difference between the highest value and the lowest value is " + difference + "\n\n");
        int[] intArray = new int[10];
        intArray[0] = 54;
        intArray[1] = 34;
        intArray[2] = 18;
        intArray[3] = 3098;
        intArray[4] = 58;
        intArray[5] = 58;
        intArray[6] = -67;
        intArray[7] = 3;
        intArray[8] = 8;
        intArray[9] = 340;
        System.out.println("---------LOWEST VALUES-----------");
        getLowestValues(intArray);
        System.out.println("----------CREATING NEW EMPLOYEES-----------");
        createEmployees();
    }

    public static int differenceBetweenValues(ArrayList<Integer> newIntList) {
        int newDifference = 0; // Value at 0 so if the list is empty there's no difference in values
        if (!newIntList.isEmpty()) { // If list is not empty we search for the value difference
            int higherValue = newIntList.getFirst();
            int lowerValue = newIntList.getLast(); // Last as we might not know the length of the list
            for (int integer : newIntList) {
                if (integer > higherValue) {
                    higherValue = integer;
                }
                else if (integer < lowerValue) {
                    lowerValue = integer;
                }
            } // We check each integer and save the highest and lowest values, then we return the difference
            newDifference = higherValue - lowerValue;
        }
        return newDifference;
    }

    public static void getLowestValues(int[] newIntArray) {
        int lowestValue1;
        int lowestValue2;
        if (newIntArray.length >= 2) { // Check if the array has enough values
            if (newIntArray[0] <= newIntArray[1]) { // Check which of the first two values is bigger
                lowestValue1 = newIntArray[0];
                lowestValue2 = newIntArray[1];
            }
            else {
                lowestValue1 = newIntArray[1];
                lowestValue2 = newIntArray[0];
            }
            for (int i = 2; i < newIntArray.length; i++) { // Start checking from the third position
                if (newIntArray[i] < lowestValue1) { // If new number is the lowest number
                    lowestValue2 = lowestValue1; // Last lowest number is now the second-lowest number
                    lowestValue1 = newIntArray[i];
                }
                else if (newIntArray[i] < lowestValue2) { // If new number is the second-lowest number
                    lowestValue2 = newIntArray[i];
                }
            }
            System.out.println("From all the values, the lowest ones are " + lowestValue1
                    + " and " + lowestValue2 + "\n\n");
        }
        else if (newIntArray.length == 1) { // If the array only has one value it's always the lowest
            System.out.println("There's only one value on the array, which is " + newIntArray[0] + "\n\n");
        }
        else { // Exceptions
            System.out.println("There are no numbers.\n\n");
        }
    }

    public static void createEmployees() {
        ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Nick", 26, "CEO", 69276.8));
        employeeList.add(new Intern("Jonas", 19, "djd", 28099, 45));
        employeeList.add(new Employee("Terry", 48, "INTERN", 6786.5));
        employeeList.add(new Intern("Jessica", 89, "CEO", 16786.5, -60));
        employeeList.add(new Employee("Olga", 36, "SUPERVISOR", 46786.5));
        employeeList.add(new Employee("Denis", 26, "MANAGER", 50000.99));
        employeeList.add(new Intern("Sonia", 28, "    ", 800, 340));
        employeeList.add(new Intern("Mariah", 14, "    EMPLOYEE", 999995, 800));
        employeeList.add(new Employee("Shaniqua", 40, "EMPLOYEE   ", 4678));
        employeeList.add(new Employee("Chardonnay", 52, "EMPLOYEE", 38740.38));
        for (Employee employee : employeeList) {
            System.out.println("\nHi! I'm " + employee.getName() + ", I'm " + employee.getAge()
                    + " years old. My position in this company is " + employee.getPosition()
                    + ", for a salary of " +employee.getSalary() + "€");
            if (employee instanceof Intern) {
                Intern intern = (Intern) employee;
                System.out.printf("I will leave this company in " + intern.getDuration() + " days.\n");
            }
        }
    }
}
