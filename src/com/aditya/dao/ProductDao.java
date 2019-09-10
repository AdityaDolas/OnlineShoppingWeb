package com.aditya.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.aditya.config.DBConnect;
import com.aditya.pojo.Product;

public class ProductDao {

	Connection con = DBConnect.getConnect();

	public boolean addProduct(Product p) {

		//System.out.print("DVHJVFHJVD" + u);
		String sql = "insert into users values(?,?,?,?,?)";
		//String sql = "insert into user_pojo values(?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);

			/*System.out.println(u.getName());*/
			ps.setString(1, p.getPName());
			ps.setString(2, p.getPPrice());
			ps.setString(3, p.getPQuantity());
			ps.setString(4, p.getPCategory());
			ps.setString(5, p.getPDescript());

			int i = ps.executeUpdate();
			if (i > 0) {
				
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Product> getProductList() {
		String sql="select * from product";
		List<Product> al=new ArrayList<>();
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Product p=new Product();
				p.setPName(rs.getString(1));
				p.setPPrice(rs.getString(2));
				p.setPQuantity(rs.getString(3));
				p.setPCategory(rs.getString(4));
				p.setPDescript(rs.getString(5));
				al.add(p);
				
			}
			return al;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return al;
	}

}
