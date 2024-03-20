

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Addition1 extends HttpServlet {
	
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=Integer.parseInt(request.getParameter("number1"));
		int j=Integer.parseInt(request.getParameter("number2"));
		int k=i+j;
		request.setAttribute("k",k);
		RequestDispatcher rd=request.getRequestDispatcher("sqservlet1");
		rd.forward(request,response);
	}

}
