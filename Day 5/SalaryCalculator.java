import java.text.DecimalFormat;

public class SalaryCalculator {

    public static void main(String[] args) {

        double[] salaries = {50000.00, 62000.50, 45000.00, 71500.75, 58000.00};

        final double INCREMENT_RATE = 0.10; // 10%

        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Original Salaries:");
        for (double salary : salaries) {
            System.out.println("$" + df.format(salary));
        }

        for (int i = 0; i < salaries.length; i++) {
            salaries[i] = salaries[i] * (1 + INCREMENT_RATE);
        }

        System.out.println("\nUpdated Salaries (after 10% hike):");
        for (double updatedSalary : salaries) {
            System.out.println("$" + df.format(updatedSalary));
        }
    }
}