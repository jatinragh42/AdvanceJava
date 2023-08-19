package in.co.rays.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.util.JDBCDataSource;


public class MarksheetModel {
	
	public Integer nextPk() throws Exception {

		int pk = 0;

//		Class.forName("com.mysql.cj.jdbc.Driver");
//
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement ps = conn.prepareStatement("select max(id) from marksheet");

		ResultSet rs = ps.executeQuery();

		while (rs.next()) {

			pk = rs.getInt(1);

		}

		return pk + 1;
	}
	
	
	public MarksheetBean FindByRoll(int rollNo) throws Exception {
		
//		    Class.forName("com.mysql.cj.jdbc.Driver");
//			
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
//			
		
		    Connection conn = JDBCDataSource.getConnection();
		    
			PreparedStatement ps = conn.prepareStatement("select * from marksheet where roll_no = ?");
			
			ps.setInt(1, rollNo);
			
			ResultSet rs = ps.executeQuery();
			
			MarksheetBean bean = new MarksheetBean();
			
			while(rs.next()) {
				
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setRollNo(rs.getInt(3));
				bean.setPhysics(rs.getInt(4));
				bean.setChemistry(rs.getInt(5));
				bean.setMaths(rs.getInt(6));
				
			}
			return bean;
			
	}
	
	public List search(MarksheetBean bean, int pageNo, int pageSize) throws Exception{
		
		Connection conn = JDBCDataSource.getConnection();
		
		//StringBuffer sql = new StringBuffer("select * from marksheet");
		
		StringBuffer sql = new StringBuffer("select * from marksheet where 1=1");
		
		if(bean != null) {
			
			if(bean.getName() != null && bean.getName().length() > 0) {
				
			sql.append(" and name like'" + bean.getName() + "%'");
			
			}
			
			if(bean.getId() != 0 && bean.getId()>0) {
				sql.append(" and id =" + bean.getId());
				
			}
			
			if(bean.getRollNo() != 0 && bean.getRollNo()>0) {
				sql.append(" and roll_no =" +bean.getRollNo());
			}
			
		
		if(pageSize > 0) {
			
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + "," + pageSize);
						
		}
		System.out.println(sql.toString());
		
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		
		ResultSet rs = ps.executeQuery();
		
		List list = new ArrayList();
		
		while(rs.next()) {
			bean = new MarksheetBean();
			
			bean.setId(rs.getInt(1));
			bean.setName(rs.getString(2));
			bean.setRollNo(rs.getInt(3));
			bean.setPhysics(rs.getInt(4));
			bean.setChemistry(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			
			list.add(bean);
			
		}
		
		
		return list;
		}
		return null;	
	}
	
	public void Add(MarksheetBean bean) throws Exception {
		
		    Connection conn = JDBCDataSource.getConnection();
		
			PreparedStatement ps = conn.prepareStatement("insert into marksheet values(?, ?, ?, ?, ?, ?)");
			
			
			ps.setInt(1, nextPk());
			ps.setString(2, bean.getName());
			ps.setInt(3, bean.getRollNo());
			ps.setInt(4,  bean.getPhysics());
			ps.setInt(5, bean.getChemistry());
			ps.setInt(6, bean.getMaths());
		
			int i = ps.executeUpdate();
			
			System.out.println(i);
	}
	
	public void testUpdate(MarksheetBean bean) throws Exception {

		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("update marksheet set name = ? where id = ?");
		
		ps.setString(1, bean.getName());
		ps.setInt(2, bean.getId());
	
		int i = ps.executeUpdate();
			
		System.out.println(i);
		
	}
	
	public void testDelete(MarksheetBean bean) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		
		PreparedStatement ps = conn.prepareStatement("Delete from marksheet where id = ?");
		
		ps.setInt(1, bean.getId());
		int i = ps.executeUpdate();
		System.out.println(i);
	}
	
	public void testAlter(MarksheetBean bean) throws Exception {
		
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancejava", "root", "root");
		
		PreparedStatement ps = conn.prepareStatement("alter table marksheet add Geography int");
		
		int i = ps.executeUpdate();
		System.out.println(i);
		
		
	}

	
	
	
	


}
