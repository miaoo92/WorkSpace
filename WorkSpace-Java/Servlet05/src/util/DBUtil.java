package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * jdbc工具类，提供了获得连接与关闭连接的操作
 * @author tarena
 *
 */
public class DBUtil {
	public static Connection getConnection() throws Exception{
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jsd1409?useUnicode=true&characterEncoding=utf8","root","");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}  
		return conn;
	}
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	public static void main(String[] args) throws Exception {
		Connection conn=getConnection();
		System.out.println(conn);
	}
	
}
