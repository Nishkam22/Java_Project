package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Returnbookservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		// out.println("Returnbookservlet");

		String booknameenteredbyuser = req.getParameter("bookname");
		String custid = req.getParameter("cid");
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
		ResultSet rss = null;
		// String str = ("SELECT password FROM users WHERE name = ? ");
		// ------------------------------------------------------------------------
		String str3 = ("SELECT * FROM issuedbooks WHERE bookname = '" + booknameenteredbyuser + "' AND custid = '"	+ custid + "' ");
		try {
			s = con.prepareStatement(str3);
			rss = s.executeQuery(str3);

			if (rss.next()) {
				String str = "delete from issuedbooks where bookname = '" + booknameenteredbyuser + "'AND custid = '"+ custid + "'";
				System.out.println(str);
				try {
					s = con.prepareStatement(str);
				} catch (SQLException e1) {
					System.out.println(" Error while creating Statement : ");
					e1.printStackTrace();
				}
				ResultSet rs = null;
				try {
					// rs = s.executeQuery(str);
					int result = s.executeUpdate(str);
				} catch (SQLException e1) {
					System.out.println(" Error while executing query : " + str);
					e1.printStackTrace();
				}

				// --------------------------------------------quantity start
				String str4 = ("update allbooks set quantity = quantity + 1 where bookname = '" + booknameenteredbyuser	+ "'");
				System.out.println(str4);
				try {
					s = con.prepareStatement(str4);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					int resultt = s.executeUpdate(str4);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// --------------------------------------------quantity end
				req.getRequestDispatcher("successreturn.jsp").forward(req, res);

			} else {
				out.println("Invalid Details");
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// ------------------------------------------------------------------------
	}

}
