package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginValidation extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String lpass = "";
		String uename = req.getParameter("username");
		String uepass = req.getParameter("pass");
		//System.out.println("before class.forname");
		PrintWriter out = resp.getWriter();
		// out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		Connection con = null;
		PreparedStatement s = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println(" Error while fetching class : ");
			e1.printStackTrace();
		}
		try {
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/library_system", "root", "");
		} catch (SQLException e1) {
			System.out.println(" Error while creating Connection : ");
			e1.printStackTrace();
		}
		// String str = ("SELECT password FROM users WHERE name = ? ");
		String str = ("SELECT password FROM users WHERE name = '" + uename + "' ");
		//System.out.println(str);
		try {
			s = con.prepareStatement(str);
			// s.setString(1, uename);
		} catch (SQLException e1) {
			System.out.println(" Error while creating Statement : ");
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = s.executeQuery(str);
		} catch (SQLException e1) {
			System.out.println(" Error while executing query : " + str);
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				try {
					lpass = rs.getString("password");
					//System.out.println(lpass);
					//System.out.println(uepass);

					// ==============================
				} catch (SQLException e) {
					System.out.println(" Error while getting data : ");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ue name = "+uename);
		System.out.println("ue pass = "+uepass);
		if (uename.equals("john")) {

			if (uepass.equals("abc")) {
				req.getRequestDispatcher("Homepage.jsp").forward(req, resp);
			} else {
				out.println("Either wrong password or wrong email");
			}
		} else {
			//System.out.println("here123");
			out.println("Either wrong password or wrong email");
			// req.getRequestDispatcher("Register.jsp").forward(req, resp);
		}
	}
}
