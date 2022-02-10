package org.example;

import org.example.model.Employee;
import org.example.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Random;

public class Tester {

    private static EmployeeService employeeService;

    private static EmployeeService getEmployeeService() {
        try {
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext2.xml");
            employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeService;
    }

    public static void main(String[] args) {
        try {
            Process process;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int ch = 0;
            do {
                System.out.print("1. create employee \n ");
                System.out.print("2. search employee \n ");
                System.out.print("3. update employee \n ");
                System.out.print("4. exit\n");
                ch = Integer.parseInt(bufferedReader.readLine());
                switch (ch) {
                    case 1:
                        System.out.print("Enter First Name:  ");
                        String fName = bufferedReader.readLine();
                        System.out.print("Enter Last Name: ");
                        String lName = bufferedReader.readLine();
                        System.out.print("Enter Email: ");
                        String email = bufferedReader.readLine();
                        Employee employee = getEmployeeService().createEmployee(new Employee(new Random().nextInt(1000), fName, lName, email));
                        System.out.println("Employee Created: " + employee);
                        break;
                    case 2:
                        System.out.println("enter Id to be searched ");
                        int empid2 = Integer.parseInt(bufferedReader.readLine());
                        employee = employeeService.searchEmpl(empid2);
                        System.out.println(employee + "  found ");
                        break;

                    case 3:
                        System.out.println("enter Id to be updated ");
                        int empid = Integer.parseInt(bufferedReader.readLine());
                        employee = employeeService.updateEmpl(empid);
                        System.out.println(employee + "updated successfully ");
                        break;

                    case 4:
                        System.out.println("exiting");
                        System.exit(0);
                    default:
                        System.out.println("enter valid choice");
                }
            }while (ch!=0);

        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}