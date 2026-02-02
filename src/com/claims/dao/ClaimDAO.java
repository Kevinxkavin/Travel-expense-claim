package com.claims.dao;

import java.sql.*;
import java.util.Date;
import com.claims.util.DBUtil;

public class ClaimDAO {

	public int generateClaimId() {
	    int id = 0;

	    try {
	        Connection connection = DBUtil.getDBConnection();
	        PreparedStatement stmt =
	            connection.prepareStatement("SELECT CLAIM_SEQ.NEXTVAL FROM DUAL");
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            id = rs.getInt(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return id;
	}

	public boolean insertClaim(
	        int id,
	        String employeeId,
	        String claimType,
	        double claimAmount,
	        java.util.Date claimDate,
	        String claimStatus) {

	    boolean success = false;

	    try {
	        Connection connection = DBUtil.getDBConnection();
	        PreparedStatement stmt =
	            connection.prepareStatement(
	                "INSERT INTO CLAIM_TBL VALUES (?,?,?,?,?,?,?)"
	            );

	        stmt.setInt(1, id);
	        stmt.setString(2, employeeId);
	        stmt.setString(3, claimType);
	        stmt.setDouble(4, claimAmount);
	        stmt.setDouble(5, 0);
	        stmt.setDate(6, new java.sql.Date(claimDate.getTime()));
	        stmt.setString(7, claimStatus);

	        success = stmt.executeUpdate() == 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return success;
	}
}
