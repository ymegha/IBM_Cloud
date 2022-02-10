package org.example.repo;
import org.example.model.Employee;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final DataSource dataSource;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    public EmployeeRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private Connection getMyConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public Employee createEmployee(Employee employee) throws SQLException {
        connection=getMyConnection();
        preparedStatement= connection.prepareStatement("insert into employees(id,first_name,last_name,email) values(?,?,?,?)");
        preparedStatement.setInt(1,employee.getEmployeeId());
        preparedStatement.setString(2, employee.getFirstName());
        preparedStatement.setString(3, employee.getLastName());
        preparedStatement.setString(4, employee.getEmail());
        preparedStatement.executeUpdate();
        return employee;
    }


    @Override
    public Employee updateEmpl(Integer employeeId) throws SQLException{
        Scanner sc=new Scanner(System.in);
        Employee e= searchEmpl(employeeId);
        if(e==null){
            System.out.println("Enter valid employeeId");
        }
        else{
            System.out.println("Enter 1st name");
            String fname=sc.next();
            System.out.println("Enter last name");
            String lname=sc.next();
            System.out.println("Enter email");
            String email=sc.next();
            connection = getMyConnection();
            preparedStatement=connection.prepareStatement("update employee set fname=?,lname=?,email=? where id=?");
            preparedStatement.setString(1, e.getFirstName());
            preparedStatement.setString(2, e.getLastName());
            preparedStatement.setString(3, e.getEmail());
            preparedStatement.setInt(4,employeeId);
            preparedStatement.executeUpdate();
            e.setFirstName(fname);
            e.setLastName(lname);
            e.setEmail(email);
            e.setEmployeeId(employeeId);


        }
        return e;
    }

    @Override
    public Employee searchEmpl(Integer employeeId) throws SQLException{
        connection=getMyConnection();
        preparedStatement=connection.prepareStatement("select * from employee where id=?");
        preparedStatement.setInt(1,employeeId);
        List<Employee> list=new ArrayList<>();
        resultSet=preparedStatement.executeQuery();
        while (resultSet.next()){
            list.add(new Employee(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
        }
            if(list.isEmpty()){
                return null;
            }
            else{
                return list.get(0);
            }
        }

    @Override
    public List<Employee> getEmployees() throws SQLException {
        return null;
    }
}

