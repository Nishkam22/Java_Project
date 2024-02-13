//package util;
//
//import java.sql.DriverManager;
//
//import com.sun.corba.se.pept.transport.Connection;
//
//public class JDBCUtil {
//
//	private static Connection con;
//
//    public static Connection getConnection() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return con;
//    }
//
//	
//}
