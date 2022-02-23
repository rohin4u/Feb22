package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws Exception{
		
		String driver="oracle.jdbc.OracleDriver";
		String jdbc_url="jdbc:oracle:thin:@localhost:1521:XE";
		String user="system";
		 String pwd="password";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement st = con.createStatement();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Begin Salary Range:");
		int beginSal=sc.nextInt();
		System.out.println("Enter End Salary Range:");
		int endSal=sc.nextInt();
		String sqlQuery=String.format("select * from employees where empSalary>%d and empSalary<%d",beginSal,endSal);
		
		boolean flag=false;
		ResultSet rs =st.executeQuery(sqlQuery);
		System.out.println("ENO\tENAME\tESALARY\tEADDR");
		System.out.println("--------------------------------------");
		while(rs.next())
		{
		flag=true;
		//System.out.println(rs.getInt("eno")+"\t"+rs.getString("ename")+"\t"+rs.getDouble("esal")+"\t"+rs.getString("eaddr"));
		 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		 }
		if(flag==false)
		{
		 System.out.println("No Records found");
		 }
		con.close();
		
	}
}


