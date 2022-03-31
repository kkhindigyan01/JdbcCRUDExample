package com.kkhindigyan.client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.kkhindigyan.util.DBUtil;

/**
* Demo of Delete operation in JDBC
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
public class DeleteJdbcExample {

	public static void main(String[] args) {
		String DELETE_SQL = "DELETE FROM employee WHERE employee_id=?";
		
		try(Connection conn = DBUtil.getMySQLConnection();PreparedStatement stmt = conn.prepareStatement(DELETE_SQL);
				Scanner scanner = new Scanner(System.in)) {
			
			System.out.println("Please Enter employee Id that u want to delete from database:");
			
			int empId = scanner.nextInt();
			stmt.setInt(1, empId);
			
			int numberOfRows = stmt.executeUpdate();
			if(numberOfRows >0) {
				System.out.println("Employee with Id ="+empId+" is deleted from database");
			}else {
				System.out.println("Employee with Id ="+empId+" not found in database..");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
