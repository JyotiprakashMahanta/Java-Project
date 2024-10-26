import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/GH")
public class A_HP extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int i = 1;
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body bgcolor='FFE5CC' style='text-align:center'>");
		pw.println("<table border='1'>");
		pw.println(
				"<tr><th>Sl No</th><th>Name</th><th>DOB</th><th>ID</th><th>Mark</th><th>ph no</th><th>mail</th><th>password</th><tr>");
		try {
			// HttpSession session = req.getSession();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				pw.println("<tr><td>" + (i++) + "</td><td>" + rs.getString(1) + "</td><td>" + rs.getString(2)
						+ "</td><td>" + rs.getString(3) + "</td><td>" + rs.getDouble(4) + "</td><td>" + rs.getString(5)
						+ "</td><td>" + rs.getString(6) + "</td><td>" + rs.getString(7) + "</td></tr>");
			}
			pw.println("</table> <br><br>");
			pw.println(
					"<form action='A_edit'><input name='id' placeholder='Enter id for EDIT'><button>edit</button></form><form action='A_Delete'><input name='id' placeholder='Enter id for Delete'><button>delete</button></form>");
			pw.println("<a href='index.html'>go back to home page</a></body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
