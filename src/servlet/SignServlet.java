package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Reader;
import dao.ReaderDAO;
//注解跳转
@WebServlet("/SignServlet")
public class SignServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//获取前台注册表数据
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String sex=request.getParameter("sex");
			Reader reader = new Reader();
			reader.setAccount(name);
			reader.setPassword(password);
			reader.setPhone(phone);
			reader.setSex(sex);
			//检查是否有重复用户
			ReaderDAO dao = new ReaderDAO();
			if(dao.checkReader(name)) {//如果用户名重复
				request.getRequestDispatcher("/failed.jsp").forward(request, response);
			}else {//用户名不重复
				dao.insertReader(reader);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
}
