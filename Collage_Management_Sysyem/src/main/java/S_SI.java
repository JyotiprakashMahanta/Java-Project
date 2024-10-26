import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class S_SI extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String mail = req.getParameter("mail");
		String pass = req.getParameter("pass");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			PreparedStatement ps = con.prepareStatement("select * from student where email=? and pass=?");
			ps.setString(1, mail);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				req.setAttribute("mail", mail);
				RequestDispatcher rd = req.getRequestDispatcher("rem");
				rd.forward(req, resp);
			} else {
				PrintWriter pw = resp.getWriter();
				pw.println("<html><body>");
				pw.println("<p style='color:red'>Invalid Password or Email</p>");
				pw.println("</body></html>");
				RequestDispatcher rd = req.getRequestDispatcher("S_signin.html");
				rd.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
