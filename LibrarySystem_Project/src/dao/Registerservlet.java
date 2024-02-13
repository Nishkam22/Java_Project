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

public class Registerservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		//out.println("account created");
		
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		String password = req.getParameter("pass");
		int age = Integer.parseInt(req.getParameter("age"));
		
		
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

		String str = ("INSERT INTO `users` (`name`, `address`, `password`, `age`) VALUES ('"+name+"','"+address+"','"+password+"','"+age+"')");
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
		req.getRequestDispatcher("Register_succesful.jsp").forward(req, res);
		
	}
	
}
