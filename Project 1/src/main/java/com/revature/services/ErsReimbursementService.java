package com.revature.services;

import java.util.List;
import java.util.stream.Collectors;

import com.revature.daos.DaoFactory;
import com.revature.daos.ReimDao;
import com.revature.models.ErsReimbursement;


public class ErsReimbursementService {

private ReimDao rd;
	
	public ErsReimbursementService() {
		rd = DaoFactory.getDaoFactory().getReimDao();
	}
	
	/**
	 * Service method to retrieve all pending reimbursements
	 * @return a List of Reimbursements or an empty list if none are found
	 */
	public List<ErsReimbursement> getPendingReim(){
		
		List<ErsReimbursement> reims = rd.getPending().stream()
				.collect(Collectors.toList());
		
		return reims;
	}

	/**
	 * Service method to retrieve all resolved reimbursements
	 * @return a List of Reimbursements or an empty list if none are found
	 */
	public List<ErsReimbursement> getResolvedReim(){
		
		List<ErsReimbursement> reims = rd.getResolved().stream()
				.collect(Collectors.toList());
		
		return reims;
	}
	
	/**
	 * Service method to retrieve all reimbursements for a specific user
	 * @param username of the employee
	 * @return a List of Reimbursements or an empty list if none are found
	 */
	public List<ErsReimbursement> getAllReimByUsername(String username){
		
		List<ErsReimbursement> reims = rd.getReimByUsername(username).stream()
				.collect(Collectors.toList());
		
		return reims;
	}
}
