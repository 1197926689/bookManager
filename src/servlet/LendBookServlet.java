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
		//�ж��Ƿ���Խ���
		if(dao.Sreader(uid,ISBN)) {
			request.getRequestDispatcher("index/index.jsp").forward(request, response);
		}else {
			String msg ="�Բ�����δ�黹��һ������߸����ѱ������";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("index/lendfailed.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
