//package dao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.sun.corba.se.pept.transport.Connection;
//
//import dto.User;
//import util.JDBCUtil;
//
//public class UserDao {
//
//	 public User getUserByUserName(String userName) {
//	        // make a coonectionWith DB
//	        // hit a query to database
//	        // get the result from result set
//	        // return object
//
////	        Connection connection = JDBCUtil.getConnection();
////	        User user = new User();
////	        try {
////	            PreparedStatement ps = connection.prepareStatement("select * from user where username=?");
////	            ps.setString(1, userName);
////	            ResultSet rs = ps.executeQuery();
////
////	            while (rs.next()) {
////	                String username = rs.getString(1);
////	                String password = rs.getString(2);
////	                // user user data tro user object
////	            }
////	        } catch (SQLException e) {
////	            e.printStackTrace();
////	        }
//
////	        return user;
//		 return null;
//	    }
//
//}
