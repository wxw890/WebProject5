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
		out.println("이름 : " + session.getAttribute("name")+"<br/>");
		out.println("접속시간 : " + new Date(session.getCreationTime())+"<br/>");
		out.println("세션 ID : " + session.getId()+"<br/>");
		out.println("세션 말료 시간 : " + session.getMaxInactiveInterval()+"<br/>");
		session.setMaxInactiveInterval(60*60*5);
		out.println("세션 만료 시간 : " + session.getMaxInactiveInterval()+"<br/>");
		if(session.isNew()){
			out.println("처음 접속하셨습니다. <br/>");
		}else{
			out.println("최근 접속하셨습니다. <br/>");
		}
		out.println("세션 종료 후 <br/>");
		session.invalidate();
		//out.println("이름 :" + session.getAttribute("name")+"<br/>");
		//out.println("세션 ID :" + session.getAttribute("name")+"<br/>");
		
	}

}
