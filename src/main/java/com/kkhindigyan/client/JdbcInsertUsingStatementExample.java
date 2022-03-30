package com.kkhindigyan.client;

import java.sql.Connection;
import java.sql.Statement;

import com.kkhindigyan.util.DBUtil;

/**
 * Demo of CREATE operation in JDBC
 * 
 * @author KK HindiGyan 
 * CRUD Means 
 * C->Create
 * R->Read
 * U->Update
 * D->Delete
 * Operations using JDBC Statement
 *
 */
public class JdbcInsertUsingStatementExample {

	public static void main(String[] args) {
		
		//insertData1();
		insertDat2();
	}

	private static void insertDat2() {
		try(Connection conn = DBUtil.getMySQLConnection();Statement stmt = conn.createStatement()) {
			
			String INSERT_SQL = "INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES ('John20',5000,'IT','2021-01-20'),('John30',5000,'IT','2021-01-20')";
			
			int numberOfRows = stmt.executeUpdate(INSERT_SQL);
			System.out.println(numberOfRows +" rows are created!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void insertData1() {
		try(Connection conn = DBUtil.getMySQLConnection();Statement stmt = conn.createStatement()) {
			
			String INSERT_SQL = "INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES ('John2',5000,'IT','2021-01-20'),('John3',5000,'IT','2021-01-20')";
			
			boolean execute = stmt.execute(INSERT_SQL);
			if(!execute) {
				System.out.println("Data is Inserted!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
