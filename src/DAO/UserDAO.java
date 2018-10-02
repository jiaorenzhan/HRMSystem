package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javaBean.User;

public class UserDAO {

	 public User find(String name){
		  User user=null;
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				String url="jdbc:mysql://127.0.0.1:3306/shopsystem?useUnicode=true&characterEncodeing=utf-8";
				Connection con =DriverManager.getConnection(url,"root","jrz975828");
				String sql="select * from user where uname=? ";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,name);
			ResultSet  rs=	ps.executeQuery();
			while(rs.next()){
	          
				 user =new User();
				 user.setUname(rs.getString("uname"));
				 user.setPsw(rs.getString("psw"));
				
			}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		   return user;
	   }
	 public  void insert(User c){
		   try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hrmsystem?useUnicode=true&characterEncodeing=utf-8","root","jrz975828");
			  PreparedStatement ps=con.prepareStatement("insert into user(uname,psw) values(?,?)");
			  ps.setString(1,c.getUname());
			  ps.setString(2,c.getPsw());		 
			  ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	   }
}
