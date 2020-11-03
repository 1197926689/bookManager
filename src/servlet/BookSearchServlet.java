package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDAO;

@WebServlet("/BookSearch")
public class BookSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String book = request.getParameter("book");
		String does = request.getParameter("do");
		if(does==""&&does==null) {
		BookDAO dao = new BookDAO();
		List<Book> books = dao.BookSearch(book);
		request.setAttribute("booklist", books);
		request.getRequestDispatcher("index/booklist.jsp").forward(request, response);
		}else {
			BookDAO dao = new BookDAO();
			List<Book> books = dao.BookSearch(book);
			request.setAttribute("booklist", books);
			request.getRequestDispatcher("reader/booklist.jsp").forward(request, response);
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
