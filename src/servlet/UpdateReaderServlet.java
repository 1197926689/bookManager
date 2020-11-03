package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Reader;
import dao.ReaderDAO;

@WebServlet("/UpdateReader")
public class UpdateReaderServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Reader r = new Reader();
		ReaderDAO dao = new ReaderDAO();
		r.setId(Integer.parseInt(request.getParameter("id")));
		r.setAccount(request.getParameter("account"));
		r.setPassword(request.getParameter("password"));
		r.setSex(request.getParameter("sex"));
		r.setPhone(request.getParameter("phone"));
		r.setReturned(request.getParameter("returned"));
		dao.UpdateReader(r);
		request.getRequestDispatcher("index/index.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
