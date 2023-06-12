package day01;

import java.sql.*;

public class ExecuteQuery02 {
    public static void main(String[] args) throws SQLException {
     Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db","dev_user","password");
    Statement st = con.createStatement();

        System.out.println("**** task1 ****");
        //1-print department name and grade of departmen which has second highest pass_grade
        String query1 ="SELECT department,pass_grade FROM departments ORDER BY pass_grade DESC LIMIT 1 OFFSET 1";
        ResultSet rs1 = st.executeQuery(query1);
        while (rs1.next()){
            System.out.println("Department : "+rs1.getString("department")+" -- "+rs1.getInt("pass_grade"));
        }

        //was asked during interview
        //2-        //1-print department name and pass_grade of department which has second highest pass_grade using sub-query
        System.out.println("**** task2 ****");
        String query2 ="select department,pass_grade from departments where pass_grade=(select max(pass_grade)" +
                "from departments where pass_grade < (select max(pass_grade) from departments ))";
        ResultSet rs2 = st.executeQuery(query2);
        while (rs2.next()){
            System.out.println("Department : "+rs2.getString("department")+" -- "+rs2.getInt("pass_grade"));

        }


        System.out.println("**** task3 ****");
        //3- List department name, campus and highest grades of students from every department
        String query3 ="select department, campus,(select max(grade) from students s where d.department=s.department)max_grade from departments d";
        ResultSet rs3  = st.executeQuery(query3);

        while (rs3.next()){
            System.out.println(rs3.getString("department") +
                    " -- " + rs3.getString("campus") +
                    " -- " + rs3.getInt("max_grade"));
        }
         st.close();
         con.close();



    }
}
