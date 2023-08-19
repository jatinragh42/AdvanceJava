package in.co.rays.test;

import java.util.Locale;
import java.util.ResourceBundle;

public class TestBundle {
	
	public static void main(String[] args) throws Exception {
		
		ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app", new Locale("hi"));
		
		System.out.println(rb.getString("greeting"));
//		System.out.println(rb.getString("url"));
//		System.out.println(rb.getString("user"));
//		System.out.println(rb.getString("password"));
//		System.out.println(Integer.parseInt(rb.getString("initial")));
//		System.out.println(Integer.parseInt(rb.getString("Acquire")));
//		System.out.println(Integer.parseInt(rb.getString("maximum")));
//				
		
	}

}
