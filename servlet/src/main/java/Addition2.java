

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


public class Addition2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int i=Integer.parseInt(request.getParameter("number1"));
		int j=Integer.parseInt(request.getParameter("number2"));
		int k=i+j;
		HttpSession session=request.getSession();
		session.setAttribute("k",k);
		RequestDispatcher rd=request.getRequestDispatcher("sqservlet2");
		rd.forward(request, response);
	
	}

}
