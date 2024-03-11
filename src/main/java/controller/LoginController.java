package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginController {
	String email,pass;
	public LoginController(String email, String pass) {
		// TODO Auto-generated constructor stub
		this.email=email;
		this.pass=pass;
	}
	static String dbURL =  "jdbc:mysql://localhost:3306/elite";
	static String dbUname = "root";
	static String dbPass = "";
	static String dbDriver = "com.mysql.cj.jdbc.Driver";
	public boolean toFetch(){
		Connection con = null;
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL,dbUname,dbPass);
			String sql = "select * from mytable3 where email='"+email+"' and pass='"+pass+"'";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
					con.close();
					return true;
					
			}

		}catch(Exception e) {
			System.out.println("Login Failed");
		}
		return false;
	}

}
