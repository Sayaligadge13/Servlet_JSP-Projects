

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


public class EditServlet extends HttpServlet {
	Connection con;
	ResultSet rs;
	PreparedStatement pst;
	int row;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/employee";
		String uname="root";
		String pass="Sayu@2670";
		PrintWriter pw=response.getWriter();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,uname,pass);
			String eid=request.getParameter("eid");
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			pst=con.prepareStatement("Update employees set fname=?,lname=? where eid=?");
			pst.setString(1,fname);
			pst.setString(2,lname);
			pst.setString(3,eid);
			pst.executeUpdate();
			pw.println("<font color='green'>Record Updated sucessfully.......");
		
		}
		catch(Exception e)
		{
		System.out.println("Error"+e);
		pw.println("Record Failed.....");
		}

}
}