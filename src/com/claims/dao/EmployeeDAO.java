package com.claims.dao;

import java.sql.*;
import com.claims.util.DBUtil;

public class EmployeeDAO {
	public double getAvailableBalance(String empId) {
	    double balance = 0;

	    try {
	        Connection con = DBUtil.getDBConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "SELECT AVAILABLE_BALANCE FROM EMPLOYEE_TBL WHERE EMPLOYEE_ID = ?"
	        );
	        ps.setString(1, empId);

	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            balance = rs.getDouble(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return balance;
	}

	public boolean updateBalance(String empId, double newBalance) {
	    boolean updated = false;

	    try {
	        Connection con = DBUtil.getDBConnection();
	        PreparedStatement ps = con.prepareStatement(
	            "UPDATE EMPLOYEE_TBL SET AVAILABLE_BALANCE = ? WHERE EMPLOYEE_ID = ?"
	        );
	        ps.setDouble(1, newBalance);
	        ps.setString(2, empId);

	        updated = ps.executeUpdate() == 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return updated;
	}
 }
