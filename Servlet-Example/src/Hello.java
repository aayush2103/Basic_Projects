
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//Servlet-Config implementation
/*		ServletConfig config = getServletConfig();
		Enumeration<String> e = config.getInitParameterNames();
		
		String str = "";
		while(e.hasMoreElements()) {
			str = e.nextElement();
			out.print("<br>" + str);
			out.print("		Value : " + config.getInitParameter(str));
		}
*/		
		String name = request.getParameter("userName");
		out.print("<br>Welcome " + name);
		
		/*RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/html/searcher.html");
		rd.include(request, response);*/
		
		//Cookie Implementtaion
		Cookie cookie = new Cookie("user", name);
		response.addCookie(cookie);
		
		out.print("<form action='cookieServlet' method='post'>");
		out.print("<input type='submit' value='go'>");
		out.print("</form>");
		// end of Cookie Implementation
		out.close();
	}

}
