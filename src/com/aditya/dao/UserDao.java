package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.aditya.config.DBConnect;
import com.aditya.pojo.User;

public class UserDao {

	Connection con = DBConnect.getConnect();

	public boolean addUser(User u) {

		//System.out.print("DVHJVFHJVD" + u);
		String sql = "insert into user values(?,?,?,?)";
		//String sql = "insert into user_pojo values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			System.out.println(u.getName());
			ps.setString(1, u.getName());
			ps.setString(2, u.getNumber());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());

			int i = ps.executeUpdate();
			if (i > 0) {
				//System.out.println("Success");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<User> getUserList(){
		String sql="select * from user";
		List<User> al=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				User u=new User();
				u.setName(rs.getString(1));
				u.setNumber(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
				al.add(u);
				
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
