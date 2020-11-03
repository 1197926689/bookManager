package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Admined;
import bean.Reader;
import connection.DBConnection;

public class LoginDAO {

	//检查用户名密码是否正确
	public boolean checkReader(Reader reader) {
		Boolean result = false;
		Connection conn = DBConnection.getconn();
		String sql = "select*from reader where uaccount=? and upassword=?";
		ResultSet rs = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, reader.getAccount());
			st.setString(2, reader.getPassword());
			rs = st.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}}
		return result;
	}
	
	public boolean checkAdmin(Admined admin) {
		Boolean result = false;
		Connection conn = DBConnection.getconn();
		String sql = "select*from admin where account=? and password=?";
		ResultSet rs = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, admin.getAccount());
			st.setString(2, admin.getPassword());
			rs = st.executeQuery();
			if(rs.next()) {
				result = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}}
		return result;
	}
}
