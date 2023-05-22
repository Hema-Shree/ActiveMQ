import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertDBResult_JavaObject{

     public static void main(String[] args) throws SQLException, JsonGenerationException, JsonMappingException, IOException {
          
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels", "root", "root");

          
          Statement stmt = con.createStatement();

          String s = "select * from customerinfo  limit 1";

          
          ResultSet rs = stmt.executeQuery(s);

          CustomerDetails cd=new CustomerDetails();
         
          while (rs.next()) {
              String bookname = rs.getString("BookName");
              String purchasedate = rs.getString("PurchasedDate");
              int amount = rs.getInt("Amount");
              String location = rs.getString("Location");
             
              cd.setBookname(bookname);
              cd.setPurchasedate(purchasedate);
              cd.setAmount(amount);
              cd.setLocation(location);
          }

         
          con.close();
                  
         
         File jsonfile=new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\mavenproject1\\src\\main\\java\\custinfo.json");
         
          ObjectMapper om=new ObjectMapper();
          om.writeValue(jsonfile, cd);
         
          System.out.println("Done!");
         
     }

}