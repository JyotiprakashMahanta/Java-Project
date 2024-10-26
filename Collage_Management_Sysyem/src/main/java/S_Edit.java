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

@WebServlet(urlPatterns = ("/sedit"))
public class S_Edit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PrintWriter pw = resp.getWriter();
			HttpSession session = req.getSession();
			String email = (String) session.getAttribute("mail");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			String mail = "select * from student where email=?";
			PreparedStatement ps = con.prepareStatement(mail);
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			pw.println("<html><body style='text-align:center'>");
			pw.println("<form action='seditoo'> <label>Name: </label> <input  name='name' value=" + rs.getString(1)
					+ " > <br>");
			pw.println("<label>D.O.B.:</label><input name='dob' value=" + rs.getString(2) + "> <br>");
			pw.println("<label>I.D.:</label><input name='id' value=" + rs.getInt(3) + "> <br>");
			pw.println("<label>Mark:</label><input name='mark' value=" + rs.getDouble(4) + "> <br>");
			pw.println("<label>Ph. No:</label><input name='ph' value=" + rs.getString(5) + "> <br>");
			pw.println("<label>Email:</label><input name='mail' value=" + email + " readonly> <br>");
			pw.println("<label>Password:</label><input name='pass' value=" + rs.getString(7) + "> <br>");
			pw.println("<button style='background:lightgreen'>update</button>");
			pw.println("</form>");
			pw.println("</body></html>");
			session.setAttribute("name", rs.getString(1));
			session.setAttribute("dob", rs.getString(2));
			session.setAttribute("id", rs.getInt(3));
			session.setAttribute("mark", rs.getDouble(4));
			session.setAttribute("ph", rs.getString(5));
			session.setAttribute("pass", rs.getString(7));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
