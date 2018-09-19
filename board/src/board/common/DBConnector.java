package board.common;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;


public class DBConnector 
{	
	public static Connection getConn() throws NamingException, SQLException
	{		
		DataSource ds = null;
		try {
			Context init = new InitialContext(); 
			ds = (DataSource) init.lookup("java:comp/env/OracleDB");					
		}
		catch(Exception e) { System.out.println("Exception - board.common.DBConnector - Exception"); }
		
		return ds.getConnection();
				
		
		
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		String id = "hr";
//		String pw = "hkitedu";
//		String url = "jdbc:oracle:thin:@localhost:1521:XE";
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		
//		conn = DriverManager.getConnection(url, id, pw);
//		return ds.getConnection();
	}
	
	public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		if(conn != null) 
		{
			try {conn.close();}
			catch(Exception e) {}
		}
		if(ps != null) 
		{
			try {ps.close();}
			catch(Exception e) {}
		}
		if(rs != null) 
		{
			try {rs.close();}
			catch(Exception e) {}
		}
	}
	
	
	public static void close(Connection c) {
		close(c, null, null);
	}
	
	public static void close(PreparedStatement p) {
		close (null, p , null);
	}
	
	public static void close(ResultSet r) {
		close (null, null , r);
	}
	
	public static void close(PreparedStatement p, ResultSet r) {
		close (null, p , r);
	}
	
	
	
	
	
	
	
	
	
}
