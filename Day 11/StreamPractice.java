
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


//Employee salary bonus calculation

class Employee{
    String name;
    double salary;
    public Employee(String name,double salary){
        this.name=name;
        this.salary=salary;
    }
    public String getName(){return name;}
    public double getSalary(){ return salary;}
    }
public class StreamPractice{
    public static void main(String[] args) {

        List<Employee> employees=Arrays.asList(
            new Employee("Mahesh",45000),
            new Employee("Pavan",75000),
            new Employee("Ram",43388),
            new Employee("Kishore",30000),
            new Employee("Harish",50999)
        );
        
        System.out.println("Employee with Orginal Salary>50000:");
        List<String> result =employees.stream()
        .filter(e -> e.getSalary() > 50000)
        .map(e -> {
            double bonus =0;
            if(e.getSalary()<=30000){
                bonus=e.getSalary()*0.15;
            }else if(e.getSalary()<=75000){
                bonus=e.getSalary()*0.12;
            } else {
                bonus=e.getSalary()*0.10;
            }
            double updatedSalary=e.getSalary()+bonus;
            return e.getName()+"Updated Salary:" +updatedSalary;
        })
        .collect(Collectors.toList());
        result.forEach(System.out::println);
        System.out.println("Total Employees earning above $50000"+result.size());
    }
}