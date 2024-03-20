


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Login extends HttpServlet {
	   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		if(uname.equals("sayali")&&pass.equals("gadge"))
		{
			pw.println("Login successful....");
		}
		else
			pw.println("Login failed try again");
	
		
	}
}
