package com.yash.ppmtool.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DbUtil {

	private static Connection con = null;
	private static PreparedStatement psmt = null;
	private static final Logger Log = Logger.getLogger(DbUtil.class);
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static Connection connection() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ppmtool", "root", "root");
			Log.info(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static PreparedStatement preparedStatement(String sql) {
           connection();
		try {
			psmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return psmt;
	}

	public static void disConnect() {
		try {
			con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public static void closePreparedStatement() {
		try {
			psmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
