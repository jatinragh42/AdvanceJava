package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class TestPreparedStatement {
	
	public static void main(String[] args) throws Exception {
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:/advancejava", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("insert into marksheet values(19,'raman', 1007, 78, 98, 99)");
	
		int i = ps.executeUpdate();
			
		System.out.println(i);
		
		
	}

}
