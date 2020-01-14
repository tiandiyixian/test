package cn.codepecker.clean.test;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.codecs.MySQLCodec;

public class SqlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ESAPI.encoder().encodeForXPath("s"); 
	}

	public boolean createUserCleansed(HttpServletRequest req) {
		Statement stmt = null;
		Connection connection = null;
		String cleansedUsername = null;
		try {
			connection = DriverManager.getConnection("", "", "");
			stmt = connection.createStatement();

			cleansedUsername = clean(req.getParameter("test"));
			
//			cleansedUsername = ESAPI.encoder().encodeForSQL(new MySQLCodec(MySQLCodec.Mode.STANDARD),cleansedUsername); 
			
			String sqlQuery = "CREATE USER " + cleansedUsername;
			stmt.executeUpdate(sqlQuery);
			String path = new File(cleansedUsername,cleansedUsername).getPath();
			Runtime.getRuntime().exec(cleansedUsername);
			Class.forName(cleansedUsername);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private  String clean(String name)
	{
		return name;
	}
	
	

}
