package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.MarksheetModel;

public class TestMarksheet {
	
	public static void main(String[] args) throws Exception {
		//TestAdd();
		//testUpdate();
		//testDelete();
		//testAlter();
		//testFindByRoll();
		TestSearch();
	}
	
	private static void TestSearch() throws Exception {
		
		MarksheetBean bean = new MarksheetBean();
		//bean.setName("r");
		//bean.setId(6);
		//bean.setRollNo(1002);
		//bean.setPhysics(11);
		//bean.setChemistry(33);
		//bean.setMaths(44);
		
		MarksheetModel model = new MarksheetModel();
		
		List list = model.search(bean, 2, 5);
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
		    bean = (MarksheetBean) it.next();
			System.out.print("\t" +bean.getId());
			System.out.print("\t" +bean.getName());
			System.out.print("\t" +bean.getRollNo());
			System.out.print("\t" +bean.getPhysics());
			System.out.print("\t" +bean.getChemistry());
			System.out.println("\t" +bean.getMaths());
		}
				
	}

	private static void testFindByRoll() throws Exception {
		
		MarksheetModel model = new MarksheetModel();
		
		MarksheetBean bean = model.FindByRoll(1004);
		
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getRollNo());
		System.out.println(bean.getPhysics());
		System.out.println(bean.getChemistry());
		System.out.println(bean.getMaths());
		
		
	}

	public static void TestAdd() throws Exception {
		
        
		MarksheetBean bean = new MarksheetBean();
		
		bean.setId(23);
		bean.setName("pooja");
		bean.setRollNo("1010");
		bean.setPhysics(78);
		bean.setChemistry(67);
		bean.setMaths(98);
		
		MarksheetModel model = new MarksheetModel();
		model.Add(bean);
		
	}
	public static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		
		bean.setName("shailendra");
		bean.setId(2);
		
		MarksheetModel model = new MarksheetModel();
		model.testUpdate(bean);
	}
	
	public static void testDelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		bean.setId(6);
		
		MarksheetModel model = new MarksheetModel();
		model.testDelete(bean);
	}
	
	public static void testAlter() throws Exception {
		MarksheetModel model = new MarksheetModel();
		model.testAlter(null);
	}

	

}