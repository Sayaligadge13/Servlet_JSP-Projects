

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class sqservlet3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int k=0;
		Cookie cookies[]=request.getCookies();
		for(Cookie c:cookies)
		{
			if(c.getName().equals("k"))
				k=Integer.parseInt(c.getValue());
		}
		k=k*k;
		PrintWriter out=response.getWriter();
		out.println("Result:"+k);
	}
	}


