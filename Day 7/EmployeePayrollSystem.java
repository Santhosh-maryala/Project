import java.util.ArrayList;
import java.util.List;

// 1. Interface Employee (Defines the contract)
interface Employee {
    String getName();
    double calculateSalary();
    String getType();
}

// 2. Concrete Types (Polymorphism)
class FullTimeEmployee implements Employee {
    private String name;
    private double monthlySalary;

    public FullTimeEmployee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    @Override
    public String getName() {
         return name;
          }
    @Override
    public double calculateSalary() {
         return monthlySalary;
          }
    @Override
    public String getType() { 
        return "FullTime"; 
        }
}

class PartTimeEmployee implements Employee {
    private String name;
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getName() { return name; }
    @Override
    public double calculateSalary() { return hourlyRate * hoursWorked; }
    @Override
    public String getType() { return "PartTime"; }
}

class ContractEmployee implements Employee {
    private String name;
    private double contractAmount;

    public ContractEmployee(String name, double contractAmount) {
        this.name = name;
        this.contractAmount = contractAmount;
    }

    @Override
    public String getName() { 
        return name; 
        }
    @Override
    public double calculateSalary() { 
        return contractAmount; }
    @Override
    public String getType() { return "Contract"; }
}

// 3. Builder Pattern for Employee Creation
class EmployeeBuilder {
    private String name;
    private String type;
    private double salary;
    private double rate;
    private int hours;

    public EmployeeBuilder setName(String name) {
         this.name = name;
          return this; 
          }
    public EmployeeBuilder setType(String type) {
        this.type = type; 
        return this;
         }
    public EmployeeBuilder setSalary(double salary) { 
        this.salary = salary; 
        return this;
         }
    public EmployeeBuilder setRate(double rate) { 
        this.rate = rate; return this;
         }
    public EmployeeBuilder setHours(int hours) { 
        this.hours = hours; 
        return this; 
        }

    public Employee build() {
        if (type.equals("FullTime")) return new FullTimeEmployee(name, salary);
        if (type.equals("PartTime")) return new PartTimeEmployee(name, rate, hours);
        if (type.equals("Contract")) return new ContractEmployee(name, salary);
        return null;
    }
}

// 4. Payroll System Application
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        // Store employees in List
        List<Employee> employees = new ArrayList<>();

        // Creating employees using Builder
        employees.add(new EmployeeBuilder().setName("Alice").setType("FullTime").setSalary(5000).build());
        employees.add(new EmployeeBuilder().setName("Bob").setType("PartTime").setRate(20).setHours(100).build());
        employees.add(new EmployeeBuilder().setName("Charlie").setType("Contract").setSalary(3000).build());

        // Generate Payroll Report
        System.out.println("--- Payroll Report ---");
        for (Employee emp : employees) {
            System.out.println("Name: " + emp.getName() + 
                               ", Type: " + emp.getType() + 
                               ", Salary: $" + emp.calculateSalary());
        }
    }
}
