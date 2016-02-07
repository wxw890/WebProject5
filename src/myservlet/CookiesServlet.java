package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesServlet extends HttpServlet {

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
		
		String name = req.getParameter("name");
		String addr = req.getParameter("addr");
		
		PrintWriter out = resp.getWriter();
		
		out.println("�̸� : "+ name + "<br/>");
		out.println("�ּ� : "+ addr + "<br/>");
		
		if(name.length()>0 && addr.length()>0){
		Cookie cookName = new Cookie("name", name);//��Ű ����
		Cookie cookAddr = new Cookie("addr", addr);
		
		cookName.setMaxAge(60*60*24);//�ʴ����� ��Ű�� ���尡��
		cookAddr.setMaxAge(60*60*24);
		
		resp.addCookie(cookName);//�޸� ��Ű
		resp.addCookie(cookAddr);
		
		out.println("��Ű�� ������Ǿ����ϴ�.");
		}
		else{
			Cookie[] cooks=req.getCookies();
	        for(int i=0; i<cooks.length; i++){
	            Cookie c= cooks[i];
	            out.println(c.getName()+":"+c.getValue());
	        }
	
		}
	}

}
