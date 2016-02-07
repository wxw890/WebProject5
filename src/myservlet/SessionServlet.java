package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("euc-kr");
		resp.setCharacterEncoding("euc-kr");
		
		PrintWriter out = resp.getWriter();
		
		String name = req.getParameter("name");
		
		HttpSession session = req.getSession();
		session.setAttribute("name", name);
		out.println("�̸� : " + session.getAttribute("name")+"<br/>");
		out.println("���ӽð� : " + new Date(session.getCreationTime())+"<br/>");
		out.println("���� ID : " + session.getId()+"<br/>");
		out.println("���� ���� �ð� : " + session.getMaxInactiveInterval()+"<br/>");
		session.setMaxInactiveInterval(60*60*5);
		out.println("���� ���� �ð� : " + session.getMaxInactiveInterval()+"<br/>");
		if(session.isNew()){
			out.println("ó�� �����ϼ̽��ϴ�. <br/>");
		}else{
			out.println("�ֱ� �����ϼ̽��ϴ�. <br/>");
		}
		out.println("���� ���� �� <br/>");
		session.invalidate();
		//out.println("�̸� :" + session.getAttribute("name")+"<br/>");
		//out.println("���� ID :" + session.getAttribute("name")+"<br/>");
		
	}

}
