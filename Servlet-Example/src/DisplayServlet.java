
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/displayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		FileInputStream fin = new FileInputStream("C:\\Users\\Aayush\\Desktop\\notes\\Images\\Servlet\\Servlet-Context.png");
		
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch=0;
		while((ch=bin.read()) != -1) {
			bout.write(ch);
		}
		bin.close();
		bout.close();
		fin.close();
		out.close();
	}

}
