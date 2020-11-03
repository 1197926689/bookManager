package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Admined;
import bean.Reader;
import dao.LoginDAO;
//注解跳转
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//从登陆表单获取数据
		String account = request.getParameter("name");
		String password = request.getParameter("password");
		Reader reader = new Reader();
		Admined admin = new Admined();
		LoginDAO dao = new LoginDAO();
		reader.setAccount(account);
		reader.setPassword(password);
		admin.setAccount(account);
		admin.setPassword(password);
		//检查用户名密码是否正确
		if(dao.checkReader(reader)) {
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			response.sendRedirect("reader/index.jsp");
		}else if(dao.checkAdmin(admin)){
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			response.sendRedirect("index/index.jsp");
		}
		else {
			response.sendRedirect("loginfail.jsp");
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}