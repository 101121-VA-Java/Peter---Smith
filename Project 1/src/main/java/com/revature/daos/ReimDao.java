package com.revature.daos;

import java.util.List;

import com.revature.models.ErsReimbursement;

public interface ReimDao {

	int add(ErsReimbursement t);
	List<ErsReimbursement> getPending();
	List<ErsReimbursement> getResolved();
	List<ErsReimbursement> getAllForEmployee(int id);
	ErsReimbursement getById(int id);
	boolean update(ErsReimbursement t);
	
}
