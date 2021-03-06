package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDaoImpl implements LoginDao{
	private static Connection conn=null;
	static PreparedStatement usel=null;
	static {
		try {
			conn=DBUtil.getMyConnection();
			usel=conn.prepareStatement("select * from user where uname=? and password=?" );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String ValidateUser(String uname, String pass) {
		try {
			usel.setString(1, uname);
			usel.setString(2, pass);
			ResultSet rs=usel.executeQuery();
			if(rs.next()) {
				return rs.getString(3);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
