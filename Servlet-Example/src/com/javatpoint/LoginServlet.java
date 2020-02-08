package com.javatpoint;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("/WEB-INF/html/link.html").include(request, response);
		
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		if(userPass.equals("admin123")) {
			out.print("<br>You are successfully logged in !!");
			out.print("<br>Welcome " + userName);
			
			/*Cookie cookie = new Cookie("userName", userName);
			response.addCookie(cookie);*/
			
			HttpSession session = request.getSession();
			session.setAttribute("name", userName);
		} else {
			out.print("Sorry, Username or Password Error !!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		out.close();
	}

}
