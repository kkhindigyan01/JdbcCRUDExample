package com.kkhindigyan.client;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kkhindigyan.util.DBUtil;

/**
* Demo of Update operation in JDBC
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
public class UpdateJdbcExample {

	public static void main(String[] args) {
		String UPDATE_SQL = "UPDATE employee set employee_salary=? WHERE employee_id=?";
		
		try(Connection conn = DBUtil.getMySQLConnection();PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL);
				) {
			
			double newSal = 90000.00;
			int employeeId = 5;
			
			stmt.setDouble(1, newSal);
			stmt.setInt(2, employeeId);
			
			int numberOfRow = stmt.executeUpdate();
			System.out.println(numberOfRow +" row is updated..");
			
			 newSal = 95000.00;
			 employeeId = 6;
			
			stmt.setDouble(1, newSal);
			stmt.setInt(2, employeeId);
			
			 numberOfRow = stmt.executeUpdate();
			System.out.println(numberOfRow +" row is updated..");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
