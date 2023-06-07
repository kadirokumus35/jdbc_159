package day01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.step register driver - (Optional)
        Class.forName("org.postgresql.Driver");

        //2.step create connection to get connected to DB
       Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db",
                "dev_user","password");

        //3.step create statement -- to executue SQL queries
        Statement statement = con.createStatement();

        // to test if we have created  connection DB
        // System.out.println("Connected successfully");

        //4.step execute SQL queries
        //task : create table employee(
        //employee_id int,
        //	employee_name varchar(20),
        //	salary real
        //)


       boolean sql1 = statement.execute("CREATE TABLE employee (employee_id int,employee_name varchar(20),salary real)");
        /*
        --execute() returns boolean value and can be used for DDL (Data Definition Language)
           DQL(Data Query Language)
        -- if it is used with DDL it return false
        -- if it is used with DQL (Select..) it return true

        */
       // System.out.println("sql1: "+sql1);

        // task 2 add varchar(20) column name "city" to employee table

        String query = "Alter table employee add column city varchar(20)";
      //  boolean sql2 = statement.execute(query);
       // System.out.println("sql2: "+sql2);

        //task3: delete employee table from schema
        String query1="drop table employee";
        statement.execute(query1);
        System.out.println(query1);

        //5.step close connection and statement
        statement.close();
        con.close();
    }
    }
