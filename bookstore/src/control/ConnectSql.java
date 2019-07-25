package control;

import java.sql.DriverManager;

import java.sql.*;

import com.mysql.jdbc.Connection;


public class ConnectSql {
	
	private static String driver = "com.mysql.jdbc.Driver";
	
	private static String url = "jdbc:mysql://127.0.0.1:3306/my_test?characterEncoding=utf8&useSSL=false";
	
	private static String user = "root";
	
	private static String password = "abc123";
	
	/*public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = (Connection)DriverManager.getConnection(url, user, password);
			System.out.println("Success connect Mysql server!");
			
			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from admin");
	        
	        while(rs.next()) {
	        	System.out.print(rs.getInt(1)+" ");
	        	System.out.print(rs.getInt(2)+" ");
	        	System.out.print(rs.getString(3)+" ");
	        	System.out.print(rs.getString(4)+" ");
	        	System.out.print(rs.getInt(5)+" ");
	        	System.out.println(rs.getString(6));
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	public static Connection getConn(String db,String table) {
		Connection conn = null;
		try {
			Class.forName(driver);
			String url1 = url.replace("my_test", db);
			conn = (Connection)DriverManager.getConnection(url1, user, password);
			System.out.println("成功连接数据库"+db);
			
			Statement stmt = conn.createStatement();
	        ResultSet rs = stmt.executeQuery("select * from "+table);
	        ResultSetMetaData rsmd = rs.getMetaData(); 
	        System.out.println("查看表："+table);
	        int col = rsmd.getColumnCount();
	        System.out.println(col);
	        while(rs.next()) {
	        	for(int i = 1;i <= col;i++) {
	        		System.out.print(rs.getObject(i)+" ");
	        	}
	        	System.out.println();
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
