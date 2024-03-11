package web_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Fetch_data {
	static String dbURL =  "jdbc:mysql://localhost:3306/elite";
	static String dbUname = "root";
	static String dbPass = "";
	static String dbDriver = "com.mysql.cj.jdbc.Driver";
	static String uname,pass;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
//		Scanner input = new Scanner(System.in);
//		uname = input.next();
//		pass = input.next();
//		input.close();
		try {
			int tag=1;
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbURL,dbUname,dbPass);
			String sql = "select * from mytable";
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			while(rs.next()) {
				System.out.println(tag++ + ". " +rs.getString(1) + " " + rs.getString(2));
			}
//			System.out.println("Entered Sucessfully");
			con.close();

		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
