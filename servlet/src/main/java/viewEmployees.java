

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class viewEmployees extends HttpServlet {
	Connection con;
	ResultSet rs;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/employee";
		String uname="root";
		String pass="Sayu@2670";
		PrintWriter pw=response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pass);
			String sql="select * from employees";
			Statement st=con.createStatement();
			rs=st.executeQuery(sql);
			pw.println("<table cellspacing='0' width='350px' border='1'>");
			pw.println("<tr><td>Employee ID</td><td>Firstname</td><td>Lastname</td>");
			while(rs.next())
			{
				pw.println("<tr>");
				pw.println("<td>"+rs.getInt("eid")+"</td>");
				pw.println("<td>"+rs.getString("fname")+"</td>");
				pw.println("<td>"+rs.getString("lname")+"</td>");
				pw.println("<td>"+"<a href='Editreturn?eid="+rs.getInt("eid")+"'>Edit</a>"+"</td>");
				pw.println("<td>"+"<a href='Delete?eid="+rs.getInt("eid")+"'>Delete</a>"+"</td>");
			pw.println("</tr>");
			
}
			pw.println("</table>");
		}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			pw.println("<font color='red'> Data failed to insert.......</font>");
			
		}
	}

}