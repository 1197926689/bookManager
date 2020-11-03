package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDAO;

@WebServlet("/Search")
public class SearchBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String does = request.getParameter("do");
		Book book = new Book();
		BookDAO dao = new BookDAO();
		book = dao.SelectBook(id);
		if(does.equals("update")) {
			request.setAttribute("book", book);
			request.getRequestDispatcher("operation/update.jsp").forward(request, response);
		}else {
			request.setAttribute("book", book);
			request.getRequestDispatcher("operation/delete.jsp").forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
