import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;

public class MyFilter implements Filter{
	
	public void init(FilterConfig arg) throws ServletException{}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException{
		
		PrintWriter out = response.getWriter();
		
		String password = request.getParameter("userPass");
		if(password.equals("admin")) {
			chain.doFilter(request, response);	//sends request to next resource
		} else {
			out.print("Username or Password error !!");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/index.html");
			rd.include(request, response);
		}
		out.close();
	}
	
	public void destroy() {}

}
