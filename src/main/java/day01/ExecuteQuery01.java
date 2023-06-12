package day01;

import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException {
        //create connection
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "password");

        //create statement
        Statement st = con.createStatement();

        //task 1: "country_name" from countries table with ID between 5 and 10
        String query = "select country_name from countries where id between 5 and 10";

        boolean sql1 = st.execute(query);
        System.out.println("sql1 : " + sql1);

        ResultSet rs = st.executeQuery(query);
/*
        rs.next();
        System.out.println(rs.getString("country_name"));

        rs.next();
        System.out.println(rs.getString("country_name"));

        rs.next();
        System.out.println(rs.getString("country_name"));

        rs.next();
        System.out.println(rs.getString("country_name"));

        rs.next();
        System.out.println(rs.getString("country_name"));

*/

        while (rs.next()) {
            //System.out.println(rs.getString("country_name"));//get column by columnlabel
            System.out.println(rs.getString(1));//get column by index number
        }

        //resultset has method such first(),last(), or next()
        //there is no method to iterate backward

        System.out.println("******* ******  Task 2 ******** ******");
        //task 2 : get "Phone_code" and "country_name" from countries table,
        // whose phone code is greater than 200
        String query2 = "select phone_code,country_name from countries where phone_code>200 order by phone_code desc";
        ResultSet rs2 = st.executeQuery(query2);
        while (rs2.next()) {
            System.out.println(rs2.getInt("phone_code") + "--" + rs2.getString("country_name"));

        }

        //TASK-3. Get all information about the developers whose salary is lowest
        System.out.println("************** TASK 3 **************");

        String query3 = "SELECT * FROM developers WHERE salary = (SELECT min(salary) FROM developers)";
        ResultSet resultSet3 = st.executeQuery(query3);

        while (resultSet3.next()) {
            System.out.println(resultSet3.getInt("id") + " -- " + resultSet3.getString("name") +
                    " -- " + resultSet3.getString("prog_lang") + " -- " + resultSet3.getDouble("salary"));
        }

        //TASK - 4 : Display students' name and grade whose grades are higher than average passing grade of departments.

        System.out.println("************** TASK 4 **************");
        String query4 = "SELECT name, grade FROM students WHERE grade > (SELECT AVG(pass_grade) FROM departments)";
        ResultSet resultSet4 = st.executeQuery(query4);
        while (resultSet4.next()) {
            System.out.println(resultSet4.getString("name") + " -- " + resultSet4.getInt("grade"));

        }

        st.close();
        con.close();

    }


}


