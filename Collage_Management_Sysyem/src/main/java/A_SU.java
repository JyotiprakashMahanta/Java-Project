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

public class A_SU extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nm");
		String mail = req.getParameter("em");
		String pass = req.getParameter("psw");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			PreparedStatement ps = con.prepareStatement("insert into admin values(?,?,?)");
			ps.setString(1, name);
			ps.setString(2, mail);
			ps.setString(3, pass);
			ps.execute();
			PrintWriter pw = resp.getWriter();
			pw.println("<html><body bgcolor='lightgreen'>");
			pw.println("<h5>" + name + " you are sign-up sucefully<h5>");
			pw.println("<form>You can sign-up now<button><a href='A_signin.html'>sign-in</a></button></form>");
			pw.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			
//			
//			
//			
	}
}
