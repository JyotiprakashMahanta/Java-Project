import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/dlt_y")
public class S_DCon extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			HttpSession hs = req.getSession();
			String email = (String) hs.getAttribute("mail");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			String mail = "delete from student where email=?";
			PreparedStatement ps = con.prepareStatement(mail);
			ps.setString(1, email);
			ps.executeUpdate();
			PrintWriter pw = resp.getWriter();
			pw.println(
					"<html><body>Sucefully Your account has been Deleted <br> <a  href='S_signup.html'><button>sign-up</button></a> </body></html>");
			pw.println("");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
