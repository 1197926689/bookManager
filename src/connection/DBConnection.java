package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/************************
 * 
 * @author 
 *
 */
public class DBConnection {

	public static Connection getconn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmanager?useUnicode=true&characterEncoding=utf8", "root", "123456");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
