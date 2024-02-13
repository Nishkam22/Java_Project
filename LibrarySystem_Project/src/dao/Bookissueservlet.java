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

public class Bookissueservlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		// out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb");
		String booknameEnteredByUser = req.getParameter("bookname");
		String custidEnteredByUser = req.getParameter("custid");
		int b = 0;
		int c = 1;
		
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
		ResultSet rs = null;
		// ----------------------------------------------------------------------UPDATED REQUIRMENT
		 
		String str3 = ("SELECT * FROM users WHERE custid = '" + custidEnteredByUser + "' ");

		try {
			s = con.prepareStatement(str3);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			rs = s.executeQuery(str3);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		try {

			System.out.println("before while loop");

			int a = 1;

			if (rs.next()) {
              //--------------------- code for only one book for one custid -----------------------------------------21-----start
				     String str5 = ("SELECT bookname FROM issuedbooks WHERE custid = '" + custidEnteredByUser + "' ");
			      	 System.out.println(str5);
				        try {
					           s = con.prepareStatement(str5);

				             } catch (SQLException e1) {
					     System.out.println(" Error while creating Statement : ");
					     e1.printStackTrace();
				         }
				// RESULT SET WAS HERE
				        ResultSet rsh = null;
				       try {
				    	  
					   rsh = s.executeQuery(str5);
				         } catch (SQLException e1) {
					     System.out.println(" Error while executing query : " + str5);
					     e1.printStackTrace();
				         }
				          try {
					         
							while (rsh.next()) {
						   try {
							   
							     String bookname_in_issued_books = rsh.getString("bookname");
							     if(bookname_in_issued_books.equals(booknameEnteredByUser)){
							    	 //to jsp
							    	 req.getRequestDispatcher("Cant_isue_twice.jsp").forward(req, res);
							    	 b = 1;
							     }
							     else{
							    	 
							     }
							     
			               } catch (SQLException e) {
				                System.out.println(" Error while getting data : ");
				               e.printStackTrace();
			                 }
		                   }
	                     } catch (SQLException e) {
		                   // TODO Auto-generated catch block
		                   e.printStackTrace();
	                  }
			  //------------------------------------------------------------------------------------------------------21------end
				          if(b==0){
				        	  while (a < 2) {
									System.out.println("inside first while");

									String custid = rs.getString("custid");
									if (custid.equals(custidEnteredByUser)) {
										String str = ("SELECT * FROM allbooks WHERE bookname = '" + booknameEnteredByUser + "' ");
										System.out.println(str);
										try {
											s = con.prepareStatement(str);

										} catch (SQLException e1) {
											System.out.println(" Error while creating Statement : ");
											e1.printStackTrace();
										}
										// RESULT SET WAS HERE
										try {
											rs = s.executeQuery(str);
										} catch (SQLException e1) {
											System.out.println(" Error while executing query : " + str);
											e1.printStackTrace();
										}
										try {
											while (rs.next()) {
												try {
													String bookid = rs.getString("bookid");
													String bookname = rs.getString("bookname");
													String price = rs.getString("price");
													int quantity = rs.getInt("quantity");
													if(quantity==0){
														//----------------cant issue more books
														req.getRequestDispatcher("out_of_stock.jsp").forward(req, res);
													}else{
														out.println(bookid + "     " + bookname + "     " + price + "       "	+ custidEnteredByUser);
														// ------------------------------------------------------------------------------------------
														String str2 = ("insert into issuedbooks values('" + bookid + "','" + bookname+ "','" + price + "','" + custidEnteredByUser + "')");
														try {
															s = con.prepareStatement(str2);
														} catch (SQLException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
														try {
															int result = s.executeUpdate(str2);
														} catch (SQLException e) {
															// TODO Auto-generated catch block
															e.printStackTrace();
														}
														// ------------------------------------------------------------------------------------------
														//---------------------------------for quantity start
														String str4 = ("update allbooks set quantity = quantity - 1 where bookid = '" + bookid + "'");
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
														//---------------------------------for quantity  end
													}
			
												} catch (SQLException e) {
													System.out.println(" Error while getting data : ");
													e.printStackTrace();
												}
												c = 2;
											}
										} catch (SQLException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}

									}
									a++;
								}
				        	  if(c==2){
								        req.getRequestDispatcher("Succesfully_book_issued.jsp").forward(req, res);
				        	  }else{
				        		  //------------wrong book name
				        		  req.getRequestDispatcher("wrong_bookname.jsp").forward(req, res);
				        	  }

				          }else{
				        	  
				          }
				          //-------------------------------------TO CUT
								//----------------------------------------------------------------------------TO CUT
			} else {
				out.println("User not rejistered");
				req.getRequestDispatcher("Register.jsp").forward(req, res);
			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		// --------------------------------------------------------------------------------------------UPDATED
		// REQUIRMENT

	}

}
