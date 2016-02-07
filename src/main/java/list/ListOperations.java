package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by shraddha on 2/6/16.
 */
public class ListOperations {

    public static void main(String[] args) {

        Employee emp1 = new Employee("Han", "Solo", 3000);
        Employee emp2 = new Employee("Luke", "Skywalker", 2000);
        Employee emp3 = new Employee("Annakin", "Skywalker", 2000);
        Employee emp4 = new Employee("Darth", "Vador" , 5000);

        List<Employee> employees = new ArrayList<>(Arrays.asList(emp1, emp2, emp3, emp4));

        /* removeIf */
        employees.removeIf(employee -> employee.getSalary() > 4500);

        /* replaceAll */
        employees.replaceAll(employee -> new Employee(employee.getFirstName().toUpperCase(), employee.getLastName().toUpperCase(), employee.getSalary()));

        /* comparators */
        Comparator<Employee> easyComparator = (e1, e2) -> e1.getSalary().compareTo(e2.getSalary());
        /*
         * This is equivalent to:
         */
        /*
        Comparator<Employee> oldComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        };
        */

        Comparator<Employee> compComparator = (e1, e2) -> {
            int c = e1.getSalary().compareTo(e2.getSalary());
            if (c != 0) return c;

            c = e1.getFirstName().compareTo(e2.getFirstName());
            if (c != 0) return c;

            return e1.getLastName().compareTo(e2.getLastName());
        };

        /* Above comparator with chaing and method reference */
        Comparator<Employee> comparator = Comparator.comparing(Employee::getSalary)
                                                    .thenComparing(Employee::getFirstName)
                                                    .thenComparing(Employee::getLastName);


        /* Sorting with above comparators */
        Collections.sort(employees, easyComparator);
        printEmployees(employees);

        Collections.sort(employees, compComparator);
        printEmployees(employees);

        Collections.sort(employees, comparator);
        printEmployees(employees);

        /* can also directly use the sort method of the list added in java 8 */
        employees.sort(comparator);
    }

    private static void printEmployees(List<Employee> employees) {
        System.out.println("Printing employees ...");
        /* forEach to replace the old for each loop */
        /*
         * for (Employee employee : employees) {
         *   System.out.println(employee);
         * }
         */
        employees.forEach(System.out::println);
        System.out.println("");
    }
}
