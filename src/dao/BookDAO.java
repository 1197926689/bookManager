package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Book;
import connection.DBConnection;

public class BookDAO {

	//查询书籍列表
	public List<Book> BookList() {
		Connection conn = DBConnection.getconn();
		List<Book> booklist = new ArrayList<Book>();
		ResultSet rs = null;
		String sql = "select*from book";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setISBN(rs.getString("isbn"));
				b.setTitle(rs.getString("title"));
				b.setPublisher(rs.getString("publisher"));
				b.setPrice(rs.getDouble("price"));
				b.setState(rs.getInt("state"));
				booklist.add(b);
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
		
		return booklist;
	}
	
	//查询书籍
	public List<Book> BookSearch(String book){
		Connection conn = DBConnection.getconn();
		List<Book> booklist = new ArrayList<Book>();
		ResultSet rs = null;
		//模糊查询书名
		String sql = "select*from book where title like '%"+book+"%'";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setISBN(rs.getString("isbn"));
				b.setTitle(rs.getString("title"));
				b.setPublisher(rs.getString("publisher"));
				b.setPrice(rs.getDouble("price"));
				b.setState(rs.getInt("state"));
				booklist.add(b);
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
		return booklist;
	}
	//归还图书
	public void ReturnBook(String uid,String isbn) {
		Connection conn = DBConnection.getconn();
		String sql1 = "update book set state=1 where isbn=?";
		String sql2 = "update reader set returned=1 where id=?";
		String sql3 = "insert into returned(bid,rid,returndate) values(?,?,?)";
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			PreparedStatement st = conn.prepareStatement(sql1);
			st.setString(1, isbn);
			st.executeUpdate();
			st = conn.prepareStatement(sql2);
			st.setString(1, uid);
			st.executeUpdate();
			st = conn.prepareStatement(sql3);
			st.setString(1, isbn);
			st.setString(2, uid);
			st.setString(3, df.format(new Date()));
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
	
//添加图书
	public void insertBook(Book book) {
		Connection conn = DBConnection.getconn();
		String sql = "insert into book(isbn,title,publisher,price,state) values(?,?,?,?,1)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, book.getISBN());
			st.setString(2, book.getTitle());
			st.setString(3, book.getPublisher());
			st.setDouble(4, book.getPrice());
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
	
	//根据ID查找图书
	public Book SelectBook(String id) {
		Book book = new Book();
		Connection conn = DBConnection.getconn();
		String sql = "select*from book where id=?";
		ResultSet rs = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				book.setId(rs.getInt("id"));
				book.setISBN(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setPrice(rs.getDouble("price"));
				book.setPublisher(rs.getString("publisher"));
				book.setState(rs.getInt("state"));
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
		return book;
	}
	
	//修改图书信息
	public void UpdateBook(Book book) {
		Connection conn = DBConnection.getconn();
		String sql = "update book set isbn=?,title=?,publisher=?,price=?,state=? where id=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, book.getISBN());
			st.setString(2, book.getTitle());
			st.setString(3, book.getPublisher());
			st.setDouble(4, book.getPrice());
			st.setInt(5, book.getState());
			st.setInt(6, book.getId());
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
	
	//删除图书
	public void DelteBook(int id) {
		Connection conn = DBConnection.getconn();
		String sql = "delete from book where id=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, id);
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
