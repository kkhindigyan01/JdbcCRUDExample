package com.kkhindigyan.client;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.kkhindigyan.util.DBUtil;

/**
 * Demo of Read operation in JDBC
 * 
 * @author KK HindiGyan 
 * CRUD Means 
 * C->Create
 * R->Read
 * U->Update
 * D->Delete
 * Operations using JDBC Statement/PreparedStatement
 *
 */
public class ReadDataFromDatabaseExample {

	public static void main(String[] args) {

		
		selectDataUsingPreparedStatement();
		//selectDataUsingStatement();
	}

	private static void selectDataUsingStatement() {

		String SELECT_SQL = "SELECT * FROM employee WHERE employee_id=5";
		
		try(Connection conn = DBUtil.getMySQLConnection();Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT_SQL)) {
			
			while (rs.next()) {
				
				int empId = rs.getInt("employee_id");
				String empName = rs.getString("employee_name");
				double empSal = rs.getDouble("employee_salary");
				String empDept = rs.getString("employee_dept");
				Date doj = rs.getDate("employee_doj");
				
				System.out.println(empId+"\t"+empName+"\t"+empSal+"\t"+doj);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	private static void selectDataUsingPreparedStatement() {
		String SELECT_SQL = "SELECT * FROM employee WHERE employee_id=?";
		
		try(Connection conn = DBUtil.getMySQLConnection();PreparedStatement stmt = conn.prepareStatement(SELECT_SQL);
				) {
			int employeeId = 6;
			stmt.setInt(1, employeeId);
			
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				
				int empId = rs.getInt("employee_id");
				String empName = rs.getString("employee_name");
				double empSal = rs.getDouble("employee_salary");
				String empDept = rs.getString("employee_dept");
				Date doj = rs.getDate("employee_doj");
				
				System.out.println(empId+"\t"+empName+"\t"+empSal+"\t"+doj);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
