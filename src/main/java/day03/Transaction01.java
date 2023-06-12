package day03;

import java.sql.*;

public class Transaction01 {
    public static void main(String[] args) throws Exception {
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbc_db", "dev_user", "password");

        //TASK-1. Transfer amount of 1000 from account_nu:1234 to account_nu:5678
        //by default it is true
        //JDBC de tum islemler otomatik commit edilir.
        con.setAutoCommit(false);// otomatik commiti kaldirdik. komuta bize gecti
        //try catch icine alip hata varsa bunu yakala deriz
        //block icinde herhangi bir adimda hata olursa
        //con rollback ile geri al tum islemleri deriz
        Savepoint sp =null;

        try {

            /*
                suppose we have other queries
             */

            sp = con.setSavepoint(); //rollback will start from here

            String query = "UPDATE accounts SET amount = amount + ? WHERE account_nu = ?";
            //create prepared statement
            PreparedStatement prs = con.prepareStatement(query);
            //first update query starts
            prs.setInt(1, -1000);
            prs.setInt(2, 1234);
            prs.executeUpdate();
            //first update query ends

            //since it is always true, exception will be thrown
            //suppose we have some problem while updating second update query
            if(false){//hata gerceklesmezse
                throw new Exception();// uygulama burada durur. bakiye  yukarda dustu ama asagıya yansımadi
                // onun icin
            }

            //after exception this update will not run
            //second update query starts
            prs.setInt(1, 1000);
            prs.setInt(2, 5678);
            prs.executeUpdate();
            //second update query end
            con.commit(); //we have set this to false, now we are committing manually
            //islemler basarili ise commit le deriz
            prs.close();

            con.close();
        }catch (Exception e){
            con.rollback(sp); //cancels all previous activities
            //islemler eskiye doner
        }
        // committen sonra rollback kulanilamaz
        //commit ile onaylamis oluyoruz. geri alamaz





    }
}
