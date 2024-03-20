
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Studentinfo extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String url="jdbc:mysql://localhost:3306/login";
		String user="root";
		String pass="Sayu@2670";
		Connection con;
		Statement st;
		PrintWriter pw=response.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pass);
			st=con.createStatement();
			String rno=request.getParameter("rno");
			String name=request.getParameter("name");
			String marks=request.getParameter("marks");
			String sql="insert into student1 values("+rno+",'"+name+"',"+marks+")";
			 st.executeUpdate(sql);
			pw.println("<font color='green'>Record inserted successfully");
		}
		
		catch(Exception e)
		{
			pw.println("<font color='red'>Record failed to load..");

		}
	
	}

}
