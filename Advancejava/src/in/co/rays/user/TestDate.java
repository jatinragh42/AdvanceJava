package in.co.rays.user;

import java.util.Date;

public class TestDate {
	
	public static void main(String[] args) {
		
		Date d = new Date();
		
		System.out.println(d.getTime());
		System.out.println(new java.sql.Date(d.getTime()));
		
		
	}

}
