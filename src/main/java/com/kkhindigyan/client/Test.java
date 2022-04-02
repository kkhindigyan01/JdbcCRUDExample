package com.kkhindigyan.client;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.kkhindigyan.util.DBUtil;

public class Test {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		try {
			//2.Open a connection
			 conn = DBUtil.getMySQLConnection();
			 stmt = conn.createStatement();

			 String INSERT_SQL = "INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES ('John2',5000,'IT','2021-01-20'),('John3',5000,'IT','2021-01-20')";
			
			 //3.Execute a sql command, for example a query or an update statement
			boolean execute = stmt.execute(INSERT_SQL);
			
			//4.Extract or get result of after query
			if (!execute) {
				System.out.println("Data is Inserted!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			//5.Clean up the environment
			if(conn !=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			if(stmt !=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}