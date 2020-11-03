package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Reader;
import connection.DBConnection;

public class ReaderDAO {

	//检查是否有重复用户
	public boolean checkReader(String name) {
		boolean result = false;
		Connection conn = DBConnection.getconn();
		String sql ="select*from reader where uaccount=?";
		ResultSet rs = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, name);
			rs  = st.executeQuery();
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
	
	//将用户信息加入数据库
	public void insertReader(Reader reader) {
		Connection conn = DBConnection.getconn();
		String sql = "insert into reader(uaccount,upassword,sex,phone) values(?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, reader.getAccount());
			st.setString(2, reader.getPassword());
			st.setString(3, reader.getSex());
			st.setString(4,reader.getPhone());
			st.executeUpdate();
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
	}
	
	//查询读者列表
		public List<Reader> ReaderList() {
			Connection conn = DBConnection.getconn();
			List<Reader> readerlist = new ArrayList<Reader>();
			ResultSet rs = null;
			String sql = "select*from reader";
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				rs = st.executeQuery();
				while(rs.next()) {
					Reader r = new Reader();
					r.setAccount(rs.getString("uaccount"));
					r.setId(rs.getInt("id"));
					r.setPassword(rs.getString("upassword"));
					r.setPhone(rs.getString("phone"));
					r.setSex(rs.getString("sex"));
					r.setReturned(rs.getString("returned"));
					readerlist.add(r);
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
			
			return readerlist;
		}
		
		public List<Reader> ReaderSearch(String reader){
			Connection conn = DBConnection.getconn();
			List<Reader> readerlist = new ArrayList<Reader>();
			ResultSet rs = null;
			//模糊查询读者姓名
			String sql = "select*from reader where uaccount like '%"+reader+"%'";
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				rs = st.executeQuery();
				while(rs.next()) {
					Reader r = new Reader();
					r.setAccount(rs.getString("uaccount"));
					r.setId(rs.getInt("id"));
					r.setPassword(rs.getString("upassword"));
					r.setPhone(rs.getString("phone"));
					r.setSex(rs.getString("sex"));
					r.setReturned(rs.getString("returned"));
					readerlist.add(r);
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
			return readerlist;
		}
		
		//借书SQL处理
		public Boolean Sreader(String uid,String ISBN) {
			Boolean result = false;
			Connection conn = DBConnection.getconn();
			String sql1 = "select*from reader where id=?";
			String sql2 = "select*from book where isbn=?";
			ResultSet rs = null;
			ResultSet rs1 = null;
			try {
				PreparedStatement st = conn.prepareStatement(sql1);
				PreparedStatement stmt = conn.prepareStatement(sql2);
				st.setString(1, uid);
				stmt.setString(1, ISBN);
				rs = st.executeQuery();
				rs1 = stmt.executeQuery();
				if(rs.next()) {
					if(rs1.next()) {
						if(rs.getBoolean("returned")&&rs1.getBoolean("state")) {
							SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
							String sql3 = "update reader set returned=0 where id=?";
							String sql4 = "update book set state=0 where isbn=?";
							String sql5 = "insert into lend(bid,rid,lenddate) values(?,?,?)";
							PreparedStatement s = conn.prepareStatement(sql3);
							s.setString(1, uid);
							s.executeUpdate();
							s = conn.prepareStatement(sql4);
							s.setString(1, ISBN);
							s.executeUpdate();
							s = conn.prepareStatement(sql5);
							s.setString(1, ISBN);
							s.setString(2, uid);
							s.setString(3, df.format(new Date()));
							s.executeUpdate();
							result = true;
						}
					}
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
		
		//查询单个用户
		public Reader Search(String id) {
			Reader reader = new Reader();
			Connection conn = DBConnection.getconn();
			String sql = "select*from reader where id=?";
			ResultSet rs = null;
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, id);
				rs = st.executeQuery();
				if(rs.next()) {
					reader.setId(rs.getInt("id"));
					reader.setAccount(rs.getString("uaccount"));
					reader.setPassword(rs.getString("upassword"));
					reader.setSex(rs.getString("sex"));
					reader.setPhone(rs.getString("phone"));
					reader.setReturned(rs.getString("returned"));
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
			return reader;
		}
		
		//更新用户信息
		public void UpdateReader(Reader r) {
			Connection conn = DBConnection.getconn();
			String sql = "update reader set uaccount=?,upassword=?,sex=?,phone=?,returned=? where id=?";
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1,r.getAccount() );
				st.setString(2, r.getPassword());
				st.setString(3, r.getSex());
				st.setString(4, r.getPhone());
				st.setString(5, r.getReturned());
				st.setInt(6, r.getId());
				st.executeUpdate();
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
		}
}
