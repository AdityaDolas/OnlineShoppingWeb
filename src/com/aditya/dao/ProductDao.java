package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.aditya.config.DBConnect;
import com.aditya.pojo.Product;

public class ProductDao {

	Connection connection = DBConnect.getConnect();

	public boolean addProduct(Product p) {

		//System.out.print("DVHJVFHJVD" + u);
		String sql = "insert into product values(?,?,?,?)";
		//String sql = "insert into user_pojo values(?,?,?,?)";
		try {
			PreparedStatement pa = connection.prepareStatement(sql);

			System.out.println(p.getPName());
			pa.setString(2, p.getPName());
			pa.setString(3, p.getPPrice());
			pa.setString(4, p.getPQuantity());
			pa.setString(5, p.getPImage());
			pa.setString(6, p.getPCategory());
			pa.setString(7, p.getPDescript());

			int i = pa.executeUpdate();
			if (i > 0) {
				//System.out.println("Success");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
