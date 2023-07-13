class Employee {
    private String name;
    private double salary;
    private int ID;

    public Employee(String name, double salary, int ID) {
        this.name = name;
        this.salary = salary;
        this.ID = ID;
    }

    public double calculateYearlySalary() {
        return salary * 12;
    }

    public void printNameAndSalary() {
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        // Create an employee object
        Employee employee = new Employee("Meghana Dasari", 5000.0, 525);

        // Calculate and print the employee's yearly salary
        double yearlySalary = employee.calculateYearlySalary();
        System.out.println("Yearly Salary: $" + yearlySalary);

        // Print the employee's name and salary
        employee.printNameAndSalary();
    }
}