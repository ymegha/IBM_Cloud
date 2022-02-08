package org.example.banking;
import java.sql.Connection;
import java.sql.DriverManager;
public class connection {
    static Connection con;
    public static Connection getConnection()
    {
        try {


            String mysqlJDBCDriver
                    = "com.mysql.cj.jdbc.Driver";

            Class.forName(mysqlJDBCDriver);
            con = DriverManager.getConnection("jdbc:mysql://localhost/bank","root","pass@word1");
        }
        catch (Exception e) {
            System.out.println("Connection Failed!");
        }

        return con;
    }
}
