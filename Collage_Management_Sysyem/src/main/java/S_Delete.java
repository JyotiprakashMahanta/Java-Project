import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = ("/sdelete"))
public class S_Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PrintWriter pw = resp.getWriter();
			HttpSession session = req.getSession();
			String email = (String) session.getAttribute("mail");
			session.setAttribute("email", email);
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			String mail = "select name from student where email=?";
			PreparedStatement ps = con.prepareStatement(mail);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			pw.println("<html><body><h4>" + rs.getString(1)
					+ " your account is going to be delete </h4><form action='dlt_y'><button style='background:red'>Yes</button></form><a href='S_signin.html'><button style='background:green'>No</button></a></body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
