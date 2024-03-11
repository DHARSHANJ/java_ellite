package web_java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Project1 {
	static String dbURL =  "jdbc:mysql://localhost:3306/elite";
	static String dbUname = "root";
	static String dbPass = "";
	static String dbDriver = "com.mysql.cj.jdbc.Driver";
	static String uname,pass,conpass,mail,phone;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
		Connection con = null;
		Class.forName(dbDriver);
		con = DriverManager.getConnection(dbURL,dbUname,dbPass);
		int tag=1;
		while(tag==1) {
		System.out.println("Enter 1 to Login or 2 to Register");
		int n=input.nextInt();
		if(n==1) {
			System.out.println("Enter your mail");
			mail = input.next();
			System.out.println("Enter your password");
			pass = input.next();
			try {
				int tag2=0;
				String sql = "select * from mytable2 where mail='"+mail+"' and pass='"+pass+"'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				if(rs.next()) {
						System.out.println("Login Successfully");
						tag2=1;
				}
				tag2=tag2/tag2;

			}catch(Exception e) {
				System.out.println("Login Failed");
			}
		}
		else if(n==2){
			System.out.println("Enter your name");
			uname = input.next();
			System.out.println("Enter your password");
			pass = input.next();
			System.out.println("Confirm password");
			conpass = input.next();
			System.out.println("Enter your mail");
			mail = input.next();
			System.out.println("Enter mobile number");
			phone = input.next();
			try {
				int tag2=1,tag3=0;
				String sql = "select * from mytable2 where mail='"+mail+"'";
				Statement s = con.createStatement();
				ResultSet rs = s.executeQuery(sql);
				for(int i=0;i<pass.length();i++) {
					if(pass.charAt(i)!=conpass.charAt(i)) {
						tag3=1;
						break;
					}
				}
				if(rs.next() || tag3==1) 
						tag2=0;
				tag2=tag2/tag2;
				String sql2 = "insert into mytable2 (name, pass, mail, phone)"+ "values('"+uname+"','"+pass+"','"+mail+"','"+phone+"')";
				Statement s2 = con.createStatement();
				s2.execute(sql2);
				System.out.println("Entered Sucessfully");
			}catch(Exception e) {
				System.out.println("Registration Failed");
			}
		}
		else {
			System.out.println("Enter Valid input \n\nEnter 1 to continue");
		}
		}
		con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		input.close();
		
	}

}
