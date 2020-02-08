
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		RequestDispatcher rd = null;
		
		if(userPass.equals("admin123")) {
			rd = request.getRequestDispatcher("servlet2");
			rd.forward(request, response);
		} else {
			out.print("Sorry !! Username or password error !");
			rd = request.getRequestDispatcher("/WEB-INF/index.html");
			rd.include(request, response);
		}
		
		out.close();
	}

}
