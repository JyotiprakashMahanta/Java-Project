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

@WebServlet(urlPatterns = ("/A_edit"))
public class A_Edit extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		try {
			HttpSession session = req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			PreparedStatement ps = con.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				pw.println("<html><body bgcolor='D7E97A' style='text-align:center'><form action='A_E_C'>"
						+ "<label>Name:</label><input name='name' value=" + rs.getString(1)
						+ "><br><label>DOB:</label> <input name='dob' value=" + rs.getString(2)
						+ "> <br> <label>I.D.:</label><input name='id' value=" + rs.getInt(3)
						+ "><br><label>Mark:</label><input name='mark' value=" + rs.getDouble(4)
						+ "><br><label>Ph no:</label><input name='ph' value=" + rs.getString(5)
						+ "><br><label>Mail:</label><input name='mail' readonly value=" + rs.getString(6)
						+ "><br><label>Pass:</label><input name='pass' value=" + rs.getString(7)
						+ "><br><button>update</button></form></body></html>");
				session.setAttribute("name", rs.getString(1));
				session.setAttribute("dob", rs.getString(2));
				session.setAttribute("id", rs.getInt(3));
				session.setAttribute("mark", rs.getDouble(4));
				session.setAttribute("ph", rs.getString(5));
				session.setAttribute("mail", rs.getString(6));
				session.setAttribute("pass", rs.getString(7));
			} else {
				pw.println("<html><body bgcolor='e05261'>Can not find any user this ID</body></html>");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
