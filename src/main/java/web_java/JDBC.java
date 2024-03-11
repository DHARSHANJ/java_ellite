package web_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class JDBC {
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
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL,dbUname,dbPass);
			String sql = "insert into mytable (name, pass)"+ "values('"+uname+"','"+pass+"')";
			Statement s = con.createStatement();
			s.execute(sql);
			con.close();
			System.out.println("Entered Sucessfully");
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
