package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter full file path: ");
        String path = sc.nextLine();

        System.out.println("Enter salary: ");
        Double salary = sc.nextDouble();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Employee> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.println("Email of people whose salary is more than " + salary);

            List<String> emails = list.stream()
                    .filter(p -> p.getSalary() > salary)
                    .map(Employee::getEmail)
                    .sorted()
                    .collect(Collectors.toList());

            emails.forEach(System.out::println);

            List<Employee> mEmployees = list.stream()
                            .filter(p -> p.getName().startsWith("M"))
                                    .collect(Collectors.toList());

            double sum = mEmployees.stream()
                    .map(Employee::getSalary)
                            .reduce(0.0, Double::sum);


            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
