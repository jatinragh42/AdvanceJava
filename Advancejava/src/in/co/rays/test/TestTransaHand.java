package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestTransaHand {
	
public static void main(String[] args) throws Exception {
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	
	    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
	    
        Statement stmt = conn.createStatement();

        int i = stmt.executeUpdate("insert into marksheet values(16,'raj', 1002, 11, 33, 44)");
        i = stmt.executeUpdate("insert into marksheet values(17,'raj', 1002, 11, 33, 44)");
        i = stmt.executeUpdate("insert into marksheet values(17,'raj', 1002, 11, 33, 44)");
        i = stmt.executeUpdate("insert into marksheet values(18,'raj', 1002, 11, 33, 44)");

  
        System.out.println(i);
        
		
	} catch (Exception e) {
		System.out.println(e);
		
	}
	
}	
}	
	