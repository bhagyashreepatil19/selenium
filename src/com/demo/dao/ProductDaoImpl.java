
package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.model.Product;

public class ProductDaoImpl implements ProductDao{
	private static Connection conn=null;
	static PreparedStatement psel,pins,pdel,pfindbyid,pupdate;
	static {
		try {
			conn=DBUtil.getMyConnection();
			psel=conn.prepareStatement("select * from product" );
			pins=conn.prepareStatement("insert into product values(?,?,?,?,?)");
			pdel=conn.prepareStatement("delete from product where pid=?");
			pfindbyid=conn.prepareStatement("select * from product where pid=?" );
			pupdate=conn.prepareStatement("update product set pname=?,qty=?,price=?,cid=? where pid=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Product> findAll() {
		try {
		ResultSet rs=psel.executeQuery();
		List<Product> plist=new ArrayList<>();
		while(rs.next()) {
			Product p=new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5));
			plist.add(p);
		}
		return plist;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
		
	}
	@Override
	public boolean save(Product p) {
		try {
			pins.setInt(1, p.getPid());
			pins.setString(2, p.getPname());
			pins.setInt(3, p.getQty());
			pins.setDouble(4, p.getPrice());
			pins.setInt(5, p.getCid());
			int n=pins.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean deletById(int pid) {
		try {
			pdel.setInt(1, pid);
			int n=pdel.executeUpdate();
			if(n>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Product findById(int pid) {
		try {
			pfindbyid.setInt(1, pid);
			ResultSet rs=pfindbyid.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
;		return null;
	}
	@Override
	public boolean updateProductById(Product p) {
		try {
			pupdate.setString(1, p.getPname());
			pupdate.setInt(2, p.getQty());
			pupdate.setDouble(3, p.getPrice());
			pupdate.setInt(4, p.getCid());
			pupdate.setInt(5, p.getPid());
			int n=pupdate.executeUpdate();
			if(n>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
