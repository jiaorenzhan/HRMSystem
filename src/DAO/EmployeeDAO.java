package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import javaBean.Employee;
import javaBean.Jobs;

public class EmployeeDAO {
	 public List<Employee> find(){
		   List<Employee> Cr= new        ArrayList<>();
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="select * from employee ";
				PreparedStatement ps=con.prepareStatement(sql);
				
			ResultSet  rs=	ps.executeQuery();
			while(rs.next()){
	          
				Employee c =new Employee();
				c.setEid(rs.getInt("eid"));
				c.setEname(rs.getString("ename"));
				c.setEmail(rs.getString("email"));
				c.setTel(rs.getString("tel"));
				c.setEdate(rs.getDate("edate"));
			    c.setJob(rs.getString("job"));
			    c.setDepart(rs.getString("depart"));
			    c.setWage(rs.getDouble("wage"));
				 Cr.add(c);
			}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		   return Cr;
	   }
	 public Employee findByName(int eid){
		 Employee c= null;
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="select * from employee where eid=? ";
				
				PreparedStatement ps=con.prepareStatement(sql);
			   ps.setInt(1, eid);
			ResultSet  rs=	ps.executeQuery();
			while(rs.next()){
	          
				 c =new Employee();
					c.setEid(rs.getInt("eid"));
					c.setEname(rs.getString("ename"));
					c.setEmail(rs.getString("email"));
					c.setTel(rs.getString("tel"));
					c.setEdate(rs.getDate("edate"));
				    c.setJob(rs.getString("job"));
				    c.setDepart(rs.getString("depart"));
				    c.setWage(rs.getDouble("wage"));
			}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		   return c;
	   }
	  public void updateEmployee(Employee c){
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
			Connection con =DriverManager.getConnection(url,"root","jrz975828");
			String sql="update employee set ename=?,email=?,tel=?,edate=?,job=?,wage=?,depart=? where eid =?";
			PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, c.getEname());
		ps.setString(2, c.getEmail());
		ps.setString(3, c.getTel());
		ps.setDate(4, new Date(c.getEdate().getTime()));
		ps.setString(5, c.getJob());
		ps.setDouble(6, c.getWage());
		ps.setString(7, c.getDepart());
		ps.setInt(8, c.getEid());
			  ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	   }
	  public void delete(int eid){
		  
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="delete from employee where eid = ?";
				PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, eid);
				  ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	  }
public void insert(Employee emp){
		  
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				 PreparedStatement ps=con.prepareStatement("insert into employee(eid,ename,email,tel,edate,job,wage,depart) values(?,?,?,?,?,?,?,?)");
				  ps.setInt(1,emp.getEid());
				  ps.setString(2,emp.getEname());
				  ps.setString(3, emp.getEmail());
				  ps.setString(4, emp.getTel());
				  ps.setDate(5, new Date(emp.getEdate().getTime()));
				  ps.setString(6,emp.getJob());
				  ps.setDouble(7, emp.getWage());
				  ps.setString(8, emp.getDepart());
				  System.out.println(emp.getEid()+"ok");
				  ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		  
		  
	  }
}
