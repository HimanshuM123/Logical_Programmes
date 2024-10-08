package java8Stream;

import java.util.*;
import java.util.stream.Collectors;

 class Employee4 {
    private String name;
    private String department;

    // Constructor
    public Employee4(String name, String department) {
        this.name = name;
        this.department = department;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }
}

public class EmployeeDepartmentMapper {

    public static void main(String[] args) {
        // Sample list of Employee4s
        List<Employee4> empList = Arrays.asList(
                new Employee4("John", "HR"),
                new Employee4("Jane", "IT"),
                new Employee4("Jack", "HR"),
                new Employee4("Doe", "Finance"),
                new Employee4("Smith", "IT")
        );

        // Convert List<Employee4> to Map<String, List<String>>
        Map<String, List<String>> departmentToEmployee4s = empList.stream()
                .collect(Collectors.groupingBy(
                        Employee4::getDepartment,
                        Collectors.mapping(Employee4::getName, Collectors.toList())
                ));

        // Print the resulting map
        departmentToEmployee4s.forEach((department, names) -> 
            System.out.println(department + ": " + names)
        );
    }
}
/*
Finance: [Doe]
HR: [John, Jack]
IT: [Jane, Smith]
*/
