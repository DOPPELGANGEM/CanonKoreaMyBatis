package common;

import java.sql.*;

public class JDBCTemplate {
	
	private static JDBCTemplate instance;
	private static Connection conn;

	public static JDBCTemplate getInstance() {
		
		if(instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}

	public Connection createConnection() {
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "CANONKOREA";
		String password = "CANONKOREA";
		
		try {
			if(conn == null || conn.isClosed()) {
				Class.forName(driverName);
				conn = DriverManager.getConnection(url, user, password);
				conn.setAutoCommit(false); // 오토커밋해제
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 연결해제
	public void close(Connection conn) {
		if(conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 커밋하기
	public void commit(Connection conn) {
		if(conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.commit();
				}
			}	catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 롤백하기
	public void rollback(Connection conn) {
		if(conn != null) {
			try {
				if(!conn.isClosed()) {
					conn.rollback();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	

}





























