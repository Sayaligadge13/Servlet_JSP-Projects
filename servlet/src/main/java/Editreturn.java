

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
import java.sql.ResultSet;


public class Editreturn extends HttpServlet {
	Connection con;
	ResultSet rs;
	PreparedStatement pst;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/employee";
		String uname="root";
		String pass="Sayu@2670";
		PrintWriter pw=response.getWriter();
		String eid=request.getParameter("eid");
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pass);
			pst=con.prepareStatement("select * from employees where eid=?");
			pst.setString(1,eid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				pw.print("<html>");
				pw.print("<form action='EditServlet' method='post'>");
				pw.println("<table>");
				pw.print("<tr><td>EmpID</td><td><input type='text' name='eid'value='"+rs.getInt("eid")+"'></td></tr>");
				pw.print("<tr><td>Firstname</td><td><input type='text' name='fname'value='"+rs.getString("fname")+"'></td></tr>");
				pw.print("<tr><td>Lastname</td><td><input type='text' name='lname'value='"+rs.getString("lname")+"'></td></tr>");
			pw.println("<tr><td colspan='2'><input type='submit'value='Edit'></td></tr>");
			pw.print("</table>");
			pw.print("</form>");
			pw.print("</html>");
			}
			
	}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			pw.println("Record Failed........");
		}
	}

}