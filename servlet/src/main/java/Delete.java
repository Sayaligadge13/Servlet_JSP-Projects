

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


public class Delete extends HttpServlet {
	Connection con;
	ResultSet rs;
	PreparedStatement pst;
	int row;
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
			pst=con.prepareStatement("delete  from employees where eid=?");
			pst.setString(1,eid);
			row=pst.executeUpdate();
			pw.println("<font color='green'>Record Deleted successfully......");
		
	}
		catch(Exception e)
		{
			System.out.println("Error"+e);
			pw.println("Record Failed.......");
		}

}
}