package in.co.rays.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import in.co.rays.util.JDBCDataSource;

public class TestJDBC {
	
	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i <= 30; i++) {
		
			System.out.println(i);
			
		testGet();
		}	
	}

	private static void testGet() throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = 7");
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			System.out.print("\t" +rs.getInt(1));
			System.out.print("\t" +rs.getString(2));
			System.out.print("\t" +rs.getInt(3));
			System.out.print("\t" +rs.getInt(4));
			System.out.print("\t" +rs.getInt(5));
			System.out.println(rs.getInt(6));
			
			
		}
		
		
		
		
		
	}

}
