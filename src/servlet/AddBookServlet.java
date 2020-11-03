package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDAO;

@WebServlet("/AddBook")
public class AddBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = new Book();
		//解决中文乱码
		request.setCharacterEncoding("UTF-8");
		book.setISBN(request.getParameter("isbn"));
		book.setTitle(request.getParameter("title"));
		book.setPublisher(request.getParameter("publisher"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		BookDAO dao = new BookDAO();
		dao.insertBook(book);
		request.getRequestDispatcher("index/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
