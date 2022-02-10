package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        /*try {
        	ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Customer customer=context.getBean("customer",Customer.class);
        //Customer customer1=context.getBean("customer",Customer.class);
        //System.out.println(customer==customer1);
		System.out.println(customer);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/

        try {
            Object object;
            ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext2.xml");



            DataSource dataSource=applicationContext.getBean("dataSource", DataSource.class);
            System.out.println(dataSource);
            Connection connection=dataSource.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select * from employees");

            while (resultSet.next())
            {
                System.out.println(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
