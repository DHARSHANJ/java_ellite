package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class RegisterController {
	String username,email,phone,pass;
	public RegisterController(String username, String email, String phone, String pass) {
		this.username=username;
		this.email=email;
		this.phone=phone;
		this.pass=pass;
	}
	static String dbURL =  "jdbc:mysql://localhost:3306/elite";
	static String dbUname = "root";
	static String dbPass = "";
	static String dbDriver = "com.mysql.cj.jdbc.Driver";
	public void toStore(){
		Connection con = null;
		try {
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL,dbUname,dbPass);
			String sql = "insert into mytable3 (name, email, phone, pass)"+ "values('"+username+"','"+email+"','"+phone+"','"+pass+"')";
			Statement s = con.createStatement();
			s.execute(sql);
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
