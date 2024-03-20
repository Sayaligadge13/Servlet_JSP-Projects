

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class EmployeeSalary extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int salary=Integer.parseInt(request.getParameter("sal"));
	int tax,nsal;
	if(salary>50000)
	{
		tax=salary*10/100;
	}
	else if(salary>30000)
	{
		tax=salary*5/100;
	}
	else
	{
		tax=0;
	}
	PrintWriter pw=response.getWriter();
	pw.println("Employee Tax"+tax);
	nsal=salary+tax;
	pw.println("Employee Net Salary"+nsal);
	}
}