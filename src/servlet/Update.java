package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Book;
import dao.BookDAO;

@WebServlet("/Update")
public class Update extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Book book = new Book();
		book.setId(Integer.parseInt(request.getParameter("id").replace(" ", "")));
		book.setISBN(request.getParameter("ISBN").replace(" ", ""));
		book.setTitle(request.getParameter("title").replace(" ", ""));
		book.setPublisher(request.getParameter("publisher").replace(" ", ""));
		book.setPrice(Double.parseDouble(request.getParameter("price").replace(" ", "")));
		book.setState(Integer.parseInt(request.getParameter("state").replace(" ", "")));
		BookDAO dao = new BookDAO();
		dao.UpdateBook(book);
		request.getRequestDispatcher("index/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
