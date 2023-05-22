/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveDataFromDB_JDBC {
    
    public static void main (String[] args)throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");
        Statement stmt = con.createStatement();
        String s = "select * from customerinfo limit 1" ;
         ResultSet rs = stmt.executeQuery(s);

         
          CustomerDetails cd=new CustomerDetails();
          while (rs.next()) {
              String bookname = rs.getString("BookName");
              String purchasedate = rs.getString("PurchasedDate");
              int amount = rs.getInt("Amount");
              String location = rs.getString("Location");
              System.out.println(bookname + "   " + purchasedate + "      " + amount+"    "+location);
          }

        
          con.close();

          System.out.println("Query executed.....");
     }

}
        
    

