package in.co.rays.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestSelect {
	
	public static void main(String[] args) throws Exception {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
			
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from marksheet");
			
			//to get only one column:-
			//ResultSet rs = stmt.executeQuery("select name from marksheet");
			//and comment out all souts except where the name is written and change its index number ex - sout(2) to sout(1)
			
			while (rs.next()) {
				
				System.out.print(rs.getInt(1));
				System.out.print(rs.getString(2));
				System.out.print(rs.getInt(3));
				System.out.print(rs.getInt(4));
				System.out.println(rs.getInt(5));
			
				
			}
	}

}
