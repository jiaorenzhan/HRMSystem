package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javaBean.Department;
import javaBean.Employee;



public class DepartDAO {
	 public List<Department> find(){
		   List<Department> Cr= new        ArrayList<>();
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="select * from department ";
				PreparedStatement ps=con.prepareStatement(sql);
				
			ResultSet  rs=	ps.executeQuery();
			while(rs.next()){
	          
				Department c =new Department();
				c.setDid(rs.getInt("did"));
				c.setDname(rs.getString("dname"));
				c.setAddress(rs.getString("address"));
				 Cr.add(c);
			}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		   return Cr;
	   }
	 public Department findByName(String n){
		 Department c= null;
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="select * from department where did=? ";
				
				PreparedStatement ps=con.prepareStatement(sql);
			   ps.setInt(1, Integer.parseInt(n));
			ResultSet  rs=	ps.executeQuery();
			while(rs.next()){
	          
				 c =new Department();
				 c.setDid(rs.getInt("did"));
				 c.setDname(rs.getString("dname"));
				c.setAddress(rs.getString("address"));
			}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		   return c;
	   }
	  public void updateDepartment(Department c){
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
			Connection con =DriverManager.getConnection(url,"root","jrz975828");
			String sql="update department set dname=?,address=? where did =?";
			PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, c.getDname());
		ps.setString(2, c.getAddress());
		ps.setInt(3, c.getDid());
			  ps.executeUpdate();
			  con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	   }
	  public void delete(int id){
		  
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="delete  from department where did =?";
				PreparedStatement ps=con.prepareStatement(sql);
		     	ps.setInt(1, id);
				  ps.executeUpdate();
				  System.out.println("ok");
				  con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		 
	  }
public void insert(Department depart){
		  
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				 PreparedStatement ps=con.prepareStatement("insert into department(did,dname,address) values(?,?,?)");
				   ps.setInt(1, depart.getDid());
				   ps.setString(2, depart.getDname());
				   ps.setString(3, depart.getAddress());
				
				  ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		  
		  
	  }
}
