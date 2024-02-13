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

public class Addbookservlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter out = res.getWriter();
		out.println("Book succesfully Added");
		
		String booknameenteredbyuser = req.getParameter("bookname");
		int quantity = Integer.parseInt(req.getParameter("qty"));
		int priceenteredbyuser = Integer.parseInt(req.getParameter("price"));
		
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

		String str = ("INSERT INTO `allbooks` (`bookname`, `price`, `quantity`) VALUES ('"+booknameenteredbyuser+"','"+priceenteredbyuser+"','"+quantity+"')");
		System.out.println(str);
		try {
			s = con.prepareStatement(str);

		} catch (SQLException e1) {
			System.out.println(" Error while creating Statement : ");
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			//rs = s.executeQuery(str);
			int result = s.executeUpdate(str);
		} catch (SQLException e1) {
			System.out.println(" Error while executing query : "+str);
			e1.printStackTrace();
		}
	
		req.getRequestDispatcher("Succesfully_bookadded.jsp").forward(req, res);
		
	}

}
