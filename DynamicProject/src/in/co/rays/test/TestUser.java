package in.co.rays.test;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUser {
	
	public static void main(String[] args) throws Exception {

		 testAdd();

		 testUpdate();

		//testSearch();

	}

	private static void testSearch() throws Exception {
		
		String dob = "1997-08-09";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		
		bean.setDob(sdf.parse(dob));

		UserModel model = new UserModel();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {

			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLoginId());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		}

	}

	private static void testUpdate() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByPk(1);

		if (bean != null) {

			bean.setFirstName("sachin");
			bean.setLastName("gupta");

			model.update(bean);

			System.out.println("User Exist & Updated");

		} else {
			System.out.println("User not exist...!!!");
		}

	}

	private static void testAdd() throws Exception {

		String dob = "1997-08-09";

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("raj");
		bean.setLastName("jat");
	    bean.setLoginId("jatin@gmail.com");
		bean.setPassword("1234");
		bean.setDob(sdf.parse(dob));
		bean.setAddress("indore");

		UserModel model = new UserModel();

		model.add(bean);

	}

}



