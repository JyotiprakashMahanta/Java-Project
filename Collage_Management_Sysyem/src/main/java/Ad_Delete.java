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

@WebServlet(urlPatterns = ("/A_Delete"))
public class Ad_Delete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");
			PreparedStatement ps = con.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			PrintWriter pw = resp.getWriter();
			pw.println("<html><body bgcolor='FF9999' style='text-align:center'>");
			pw.println("<h2>sucefully deleted account</h2><br>");
			pw.println("<a href='A_signin.html'>sign-in</a>");
			pw.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
