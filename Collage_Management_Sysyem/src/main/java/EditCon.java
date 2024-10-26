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

@WebServlet(urlPatterns = ("/seditoo"))
public class EditCon extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String dob = req.getParameter("dob");
		int id = Integer.parseInt(req.getParameter("id"));
		double mark = Double.parseDouble(req.getParameter("mark"));
		String ph = req.getParameter("ph");
		String mail = req.getParameter("mail");
		String pass = req.getParameter("pass");
		PrintWriter pw = resp.getWriter();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");

			PreparedStatement un = con.prepareStatement("update student set name=? where email=?");
			un.setString(1, name);
			un.setString(2, mail);
			un.executeUpdate();

			PreparedStatement udob = con.prepareStatement("update student set dob=? where email=?");
			udob.setString(1, dob);
			udob.setString(2, mail);
			udob.executeUpdate();

			PreparedStatement uid = con.prepareStatement("update student set id=? where email=?");
			uid.setInt(1, id);
			uid.setString(2, mail);
			uid.executeUpdate();

			PreparedStatement um = con.prepareStatement("update student set mark=? where email=?");
			um.setDouble(1, mark);
			um.setString(2, mail);
			um.executeUpdate();

			PreparedStatement uph = con.prepareStatement("update student set ph=? where email=?");
			uph.setString(1, ph);
			uph.setString(2, mail);
			uph.executeUpdate();

			PreparedStatement upass = con.prepareStatement("update student set pass=? where email=?");
			upass.setString(1, pass);
			upass.setString(2, mail);
			upass.executeUpdate();

//			
			pw.println("<html><body bgcolor='orange' style='text-align:center'>");
			pw.println("<h2>" + name + " your data is sucefully updated</h2>");
			pw.println("<a href='S_signin.html'>sign-in</a>");
			pw.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
