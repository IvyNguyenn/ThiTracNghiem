package com.vy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBconnect {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/thi_trac_nghiem?characterEncoding=UTF-8";
			con = DriverManager.getConnection(connectionUrl,"root", "");
			
			String query = "SELECT * FORM STUDENTS";
			PreparedStatement ps = con.prepareCall(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
				System.out.print(rs.getInt("mssv"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}