package com.claims.service;

import java.util.Date;
import com.claims.dao.*;
import com.claims.util.*;

public class ClaimSer {

    EmployeeDAO empDao = new EmployeeDAO();
    ClaimDAO claimDao = new ClaimDAO();

    public boolean submitClaim(
            String empId,
            String claimType,
            double amount,
            Date date)
            throws ValidationException, InsufficientLimitException {

        if (empId == null || claimType == null || amount <= 0)
            throw new ValidationException();

        double balance = empDao.getAvailableBalance(empId);

        if (amount > balance)
            throw new InsufficientLimitException();

        try {
            double newBalance = balance - amount;
            empDao.updateBalance(empId, newBalance);

            int claimId = claimDao.generateClaimId();
            claimDao.insertClaim(
                claimId,
                empId,
                claimType,
                amount,
                date,
                "PENDING"
            );

            DBUtil.getDBConnection().commit();
            return true;

        } catch (Exception e) {
            try { DBUtil.getDBConnection().rollback(); } catch (Exception ex) {}
            return false;
        }
    }
}
