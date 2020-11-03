package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Reader;
import dao.ReaderDAO;
//ע����ת
@WebServlet("/SignServlet")
public class SignServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//��ȡǰ̨ע�������
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String phone=request.getParameter("phone");
			String sex=request.getParameter("sex");
			Reader reader = new Reader();
			reader.setAccount(name);
			reader.setPassword(password);
			reader.setPhone(phone);
			reader.setSex(sex);
			//����Ƿ����ظ��û�
			ReaderDAO dao = new ReaderDAO();
			if(dao.checkReader(name)) {//����û����ظ�
				request.getRequestDispatcher("/failed.jsp").forward(request, response);
			}else {//�û������ظ�
				dao.insertReader(reader);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
}
