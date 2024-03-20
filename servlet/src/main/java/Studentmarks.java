

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Studentmarks extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int m1=Integer.parseInt(request.getParameter("m1"));
		int m2=Integer.parseInt(request.getParameter("m2"));
		int m3=Integer.parseInt(request.getParameter("m3"));
		int total=m1+m2+m3;
		pw.println("Total:"+total);
		int avg=total/3;
		pw.println("Average:"+avg);
		if(avg>50)
		{
			pw.println("your Grade is pass");
			
		}
		else
		{
			pw.println("Your Grade is fail...Try again");
			
		}
	}

}
