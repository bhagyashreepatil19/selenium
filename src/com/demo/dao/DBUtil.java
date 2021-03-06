package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	public static Connection getMyConnection() {
		if (conn==null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://localhost:3306/test";
				conn=DriverManager.getConnection(url,"root","root");
				if(conn!=null) {
					System.out.println("connection done");
				}
				else {
					System.out.println("connection not done");
				}
			} catch (SQLException e) {
		
				e.printStackTrace();
			}
		}
		
		return conn;
	}
    public static void closeMyConnection() {
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
