//package servlet;
//
//import java.beans.Statement;
//import java.io.IOException;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.sun.corba.se.pept.transport.Connection;
//
//import dto.User;
//import service.UserService;
//
//public class LoginServlet extends HttpServlet {
//
//	 UserService service = new UserService();
//
//	    @Override
//	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	        String username = req.getParameter("");
//	        String password = req.getParameter("");
//	        boolean validUser = service.isValidUser(username, password);
//	        if (validUser) {
//	            // dispatch to next page or request
//	        } else {
//	            // not a valiid user and dispactch on login
//	        }
//	    }
//	
//
//	
//}
