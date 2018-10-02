package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import javaBean.Jobs;

public class JobsDAO {
	 public List<Jobs> find(){
		   List<Jobs> Cr= new        ArrayList<>();
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="select * from jobs ";
				PreparedStatement ps=con.prepareStatement(sql);
				
			ResultSet  rs=	ps.executeQuery();
			while(rs.next()){
	          
				Jobs c =new Jobs();
				c.setJid(rs.getString("jid"));
				c.setJname(rs.getString("jname"));
				c.setMinwage(rs.getDouble("minwage"));
				c.setMaxwage(rs.getDouble("maxwage"));
				 Cr.add(c);
			}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		   return Cr;
	   }
	 public Jobs findByName(String jid){
		 Jobs c= null;
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="select * from jobs where jid=? ";
				
				PreparedStatement ps=con.prepareStatement(sql);
			   ps.setString(1, jid);
			ResultSet  rs=	ps.executeQuery();
			while(rs.next()){
	          
				 c =new Jobs();
				 c.setJid(rs.getString("jid"));
				 c.setJname(rs.getString("jname"));
				c.setMinwage(rs.getDouble("minwage"));
				c.setMaxwage(rs.getDouble("maxwage"));
			}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		   return c;
	   }
	  public void updateJobs(Jobs c){
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
			Connection con =DriverManager.getConnection(url,"root","jrz975828");
			String sql="update jobs set jname=?,minwage=?,maxwage=? where jid =?";
			PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, c.getJname());
		ps.setDouble(2, c.getMinwage());
		ps.setDouble(3, c.getMaxwage());
		ps.setString(4, c.getJid());
			  ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	   }
	  public void delete(String jid){
		  
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="delete  from jobs where jid = ?";
				PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, jid);
				  ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	  }
 public void insert(Jobs job){
		  
		  try {
			  Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				 PreparedStatement ps=con.prepareStatement("insert into jobs(jid,jname,minwage,maxwage) values(?,?,?,?)");
				  ps.setString(1,job.getJid());
				  ps.setString(2,job.getJname());
				  ps.setDouble(3, job.getMinwage());
				  ps.setDouble(4, job.getMaxwage());
				  
				  ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
		  
		  
	  }
}
