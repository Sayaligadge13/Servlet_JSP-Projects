



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Addition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=Integer.parseInt(request.getParameter("num1"));
		int j=Integer.parseInt(request.getParameter("num2"));
		int k=i+j;
		PrintWriter pw=response.getWriter();
		pw.println("Addition:"+k);
		
	}

}
