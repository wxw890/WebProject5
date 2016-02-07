package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletInfo extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = resp.getWriter();
		
		out.println("<html><body>");
		out.println("method :"+req.getMethod()+"<br/>");
		out.println("Request URI :"+req.getRequestURI()+"<br/>");
		out.println("Protocol :"+req.getProtocol()+"<br/>");
		out.println("Path Info :"+req.getPathInfo()+"<br/>");
		out.println("Remote Addr :"+req.getRemoteAddr()+"<br/>");
		out.println("Context Path :"+req.getContextPath()+"<br/>");
		out.println("Servlet Context :"+req.getServletContext()+"<br/>");
		out.println("Servlet Path :"+req.getServletPath()+"<br/>");
		
		out.println("<hr/>");
		
		Enumeration en = req.getHeaderNames();
		while(en.hasMoreElements()){
			out.println(en.nextElement()+"<br/>");
		}
		/*
	    * accept
		 accept-language
		 cache-control
		 ua-cpu
		 accept-encoding
		 user-agent
		 host
		 connection
		 */
		out.println("accept-language : " + req.getDateHeader("accept-languge")+"<br/>");
		out.println("user-agent : " + req.getHeader("user-agent")+"<br/>");
		out.println("host : " + req.getHeader("host")+"<br/>");
		out.println("accept-encoding : " + req.getHeader("accept-encoding")+"<br/>");
		out.println("cache-controlcache-control : " + req.getHeader("cache-control")+"<br/>");
		out.println("ua-cpu : " + req.getHeader("ua-cpu")+"<br/>");
		out.println("connection : " + req.getHeader("connection")+"<br/>");
		
	}

}
