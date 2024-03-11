package web_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	static String dbURL =  "jdbc:mysql://localhost:3306/elite";
	static String dbUname = "root";
	static String dbPass = "";
	static String dbDriver = "com.mysql.cj.jdbc.Driver";
	static String uname,pass;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Scanner input = new Scanner(System.in);
		uname = input.next();
		pass = input.next();
		input.close();
		try {
			int tag=0;
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL,dbUname,dbPass);
			String sql = "select * from mytable where name='"+uname+"' and pass='"+pass+"'";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			if(rs.next()) {
					System.out.println("Login Successfully");
					tag=1;
			}
			tag=tag/tag;
			con.close();

		}catch(Exception e) {
			System.out.println("Login Failed");
		}
	}

}
