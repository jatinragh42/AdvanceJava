package in.co.rays.user;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUser {
	
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		testUpdate();
		
	}

	private static void testAdd() throws Exception {
		String dob = "2001-01-19";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserBean bean = new UserBean();
		
		bean.setId(3);
		bean.setFirstName("kapil");
		bean.setLastName("raghuwanshi");
		bean.setLoginId("kapil95@gmail.com");
		bean.setPassword("457657");
		bean.setDob(sdf.parse(dob));
		bean.setAddress("ashoknagar");
		
		UserModel model = new UserModel();
		model.add(bean);
		 
		 
		
	}

	private static void testUpdate() throws Exception {
		
		UserModel model = new UserModel();
		UserBean bean = model.FindByPk(1);
		
		if(bean != null) {
			bean.setFirstName("vikas");
			bean.setLastName("thakur");
			
			model.update(bean);
			
			System.out.println("user exist & updated");
			
		}else {
			
			System.out.println("user not exist");
		}
		
		
		
	}
	

}
