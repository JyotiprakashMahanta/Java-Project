import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = ("/sub"))
public class S_SU extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String name = req.getParameter("nm");
		String dob = req.getParameter("do");
		int id = Integer.parseInt(req.getParameter("id"));
		Double mark = Double.parseDouble(req.getParameter("mk"));
		String ph = req.getParameter("ph");
		String mail = req.getParameter("em");
		String pass = req.getParameter("ps");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, dob);
			ps.setInt(3, id);
			ps.setDouble(4, mark);
			ps.setString(5, ph);
			ps.setString(6, mail);
			ps.setString(7, pass);
			ps.execute();
			pw.println("<html><body bgcolor='lightgreen'>");
			pw.println("<h5>" + name + " you are sign-up sucefully<h5>");
			pw.println("<form>You can sign-up now<button><a href='S_signin.html'>sign-in</a></button></form>");
			pw.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
//			RequestDispatcher rd = req.getRequestDispatcher("mailT.html" + mail);
//			rd.forward(req, resp);

			pw.println("<html><body bgcolor='f99a4c' style='text-align:center;color:226f0c'>");
			pw.println("<h3><u>" + mail + "</u> already exist please provide a different mail..</h3>");
			pw.println("<br><a href='S_signup.html'>sign-up here</a>");
			pw.println("</body></html>");
		}
	}
}
