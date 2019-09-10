package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.aditya.config.DBConnect;

public class LoginDao {

	/*String sql = "SELECT * FROM USER  where UserName=? and Password=?";
	String url = "jdbc:mysql://localhost:3306/user";
	String username = "root";
	String password = "root";
	*/
	//String sql = "SELECT * FROM USER_POJO  where ame=? and password=?";
	String sql = "SELECT * FROM users  where UserName=? and password=?";
	
	/*String url = "jdbc:postgresql://ec2-184-73-169-163.compute-1.amazonaws.com:5432/dbp79kqc8onoie";
	String username = "zcazflfwugurmv";
	String password = "642eff7aa8bf44f5c06232bc10d29498b9913871abf055d5a6d4a3252bceb9be";*/

	public boolean check(String uname, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DBConnect.getConnect();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, uname);
			statement.setString(2, pass);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

}
