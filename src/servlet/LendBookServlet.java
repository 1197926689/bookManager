package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReaderDAO;

@WebServlet("/LendBook")
public class LendBookServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String ISBN = request.getParameter("ISBN");
		ReaderDAO dao = new ReaderDAO();
		//判断是否可以借书
		if(dao.Sreader(uid,ISBN)) {
			request.getRequestDispatcher("index/index.jsp").forward(request, response);
		}else {
			String msg ="对不起，您未归还上一本书或者改书已被借出。";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index/lendfailed.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
