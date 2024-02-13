package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Allbooksservlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		PrintWriter out = res.getWriter();
		//out.println("succesfully at all books servlet");
		ArrayList<Allbookdata> std = new ArrayList<Allbookdata>();
		
		
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
//		String str = ("SELECT password FROM users WHERE name = ? ");
		String str = "SELECT * FROM allbooks";
		System.out.println(str);
		try {
			s = con.prepareStatement(str);	
		} catch (SQLException e1) {
			System.out.println(" Error while creating Statement : ");
			e1.printStackTrace();
		}
		ResultSet rs = null;
		try {
			rs = s.executeQuery(str);
		} catch (SQLException e1) {
			System.out.println(" Error while executing query : "+str);
			e1.printStackTrace();
		}
		try {
			while (rs.next()) {
				try {
					String bookname = rs.getString("bookname");
					int bookid = rs.getInt("bookid");
					int price = rs.getInt("price");
					int quantity = rs.getInt("quantity");
					
					//out.println(bookid+"  "+bookname+"  "+price+"    "+quantity);
					std.add(new Allbookdata(bookid,bookname,price,quantity));
					
				} catch (SQLException e) {
					System.out.println(" Error while getting data : ");
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.setAttribute("data", std);
		//RequestDispatcher rd = req.getRequestDispatcher("Allbooks.jsp");
		req.getRequestDispatcher("Allbooks.jsp").forward(req, res);
	}

}
