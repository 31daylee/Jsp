package kr.farmstory1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBHelper {

	protected Connection conn = null;
	protected PreparedStatement psmt = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	
	public Connection getConnection () {
		
		try {
			Context ctx = (Context) new InitialContext().lookup("java:comp/env");
			DataSource ds = (DataSource)ctx.lookup("jdbc/Farmstory");
			conn = ds.getConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void close() throws SQLException {
		if(conn != null) {
			rs.close();
		}
		if(psmt != null) {
			rs.close();
		}
		if(stmt != null) {
			rs.close();
		}
		if(rs != null) {
			rs.close();
		}
	}
	
}
