

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Employeefile extends HttpServlet {
	Connection con;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	String url="jdbc:mysql://localhost:3306/employee";
	String uname="root";
	String pass="Sayu@2670";
	PrintWriter pw=response.getWriter();
	String eid=request.getParameter("eid");
	String fname=request.getParameter("fname");
	String lname=request.getParameter("lname");
	String query="insert into employees values(?,?,?)";
	try
	{
	Class.forName("com.mysql.jdbc.Driver");
	con=DriverManager.getConnection(url,uname,pass);
	PreparedStatement pst=con.prepareStatement(query);
	pst.setString(1,eid);
	pst.setString(2,fname);
	pst.setString(3,lname);
	pst.executeUpdate();
	pw.println("<font color='green'> Data inserted successfully......");
	}
	
	catch(Exception e)
	{
		System.out.println("Error"+e);
		pw.println("<font color='red'> Data failed to insert......");
		
	}
	}

}