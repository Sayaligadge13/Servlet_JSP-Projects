

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


public class Login1 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		if(uname.equals("siddhthorat")&& pass.equals("siddh"))
		{
			HttpSession session=request.getSession(true);
			session.putValue("username", uname);
			response.sendRedirect(request.getContextPath()+"/Login2");
		}
		else
		{
			out.println("fail");
		}
	}

}