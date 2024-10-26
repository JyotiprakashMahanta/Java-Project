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

@WebServlet(urlPatterns = ("/A_E_C"))
public class A_Edit_E extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PrintWriter pw = resp.getWriter();
//			HttpSession session = req.getSession();
			String name = req.getParameter("name");
			String dob = req.getParameter("dob");
			int id = Integer.parseInt(req.getParameter("id"));
			double mark = Double.parseDouble(req.getParameter("mark"));
			String mail = req.getParameter("mail");
			String pass = req.getParameter("pass");
			String ph = req.getParameter("ph");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/institude?user=root&&password=root");

			PreparedStatement ps = con.prepareStatement("update student set name=? where email=?");
			ps.setString(1, name);
			ps.setString(2, mail);
			ps.executeUpdate();

			PreparedStatement pdob = con.prepareStatement("update student set dob=? where email=?");
			pdob.setString(1, dob);
			pdob.setString(2, mail);
			pdob.executeUpdate();

			PreparedStatement pid = con.prepareStatement("update student set id=? where email=?");
			pid.setInt(1, id);
			pid.setString(2, mail);
			pid.executeUpdate();

			PreparedStatement pm = con.prepareStatement("update student set mark=? where email=?");
			pm.setDouble(1, mark);
			pm.setString(2, mail);
			pm.executeUpdate();

			PreparedStatement pmail = con.prepareStatement("update student set ph=? where email=?");
			pmail.setString(1, ph);
			pmail.setString(2, mail);
			pmail.executeUpdate();
			System.out.println("ok");
			PreparedStatement pp = con.prepareStatement("update student set pass=? where email=?");
			pp.setString(1, pass);
			pp.setString(2, mail);
			pp.executeUpdate();

			pw.println("<html><body bgcolor='lightgreen' style='text-align:center'>");
			pw.println("<h2>" + name + " Sucefully update your data.</h2>");
			pw.println("<a href='A_signin.html'>go back to sign-in page</a>");
			pw.println("</body></html>");

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
