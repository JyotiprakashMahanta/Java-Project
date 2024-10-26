import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/rem")
public class S_HP extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String mail = (String) req.getAttribute("mail");
			HttpSession session = req.getSession();
			session.setAttribute("mail", mail);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			Statement stmt = con.createStatement();
			PreparedStatement ps = con.prepareStatement("select * from student where email=?");
			ps.setString(1, mail);
			ResultSet rs = ps.executeQuery();
			PrintWriter pw = resp.getWriter();
			pw.println("<html><body>");
			pw.println("<table border='1'>");
			pw.println(
					"<tr> <th>Name</th> <th>DOB</th> <th>ID</th><th>Mark</th> <th>Phone No.</th> <th>Email</th> <th>Password</th></tr>");
			while (rs.next()) {
				pw.println("<tr><td>" + rs.getString(1) + "</td><td>" + rs.getString(2) + "</td><td>" + rs.getString(3)
						+ "</td><td>" + rs.getDouble(4) + "</td><td>" + rs.getString(5) + "</td><td>" + rs.getString(6)
						+ "</td><td>" + rs.getString(7)
						+ "</td><td><form action='sedit'><button style='background:lightgreen'>edit</button></form><td><td><form action='sdelete'><button style='background:#f3d3d9'>delete</button></form><td></tr>");
			}
			pw.println("</table><a href='index.html'>back to home page</a></body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
