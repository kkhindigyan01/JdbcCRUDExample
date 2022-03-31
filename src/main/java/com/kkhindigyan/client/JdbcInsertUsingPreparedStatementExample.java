package com.kkhindigyan.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;

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
 * Operations using JDBC PreparedStatement
 *
 */
public class JdbcInsertUsingPreparedStatementExample {

	public static void main(String[] args) {
		
		String INSERT_SQL = "INSERT INTO employee (employee_name,employee_salary,employee_dept,employee_doj) VALUES (?,?,?,?)";
		
		try(Connection conn = DBUtil.getMySQLConnection();PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
			
			stmt.setString(1, "Suresh2");
			stmt.setDouble(2, 10000.00);
			stmt.setString(3, "Finance");
			stmt.setObject(4, LocalDate.of(2022, 03, 30));
			
			int numberOfRows = stmt.executeUpdate();
			System.out.println(numberOfRows +" row is created!!");
			
			stmt.setString(1, "Rakesh2");
			stmt.setDouble(2, 12000.00);
			stmt.setString(3, "Finance");
			stmt.setObject(4, LocalDate.of(2022, 03, 30));
			
			int numberOfRows2 = stmt.executeUpdate();
			System.out.println(numberOfRows2 +" row is created!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
