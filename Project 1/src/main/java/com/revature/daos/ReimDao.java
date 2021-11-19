package com.revature.daos;

import java.util.Collection;
import java.util.List;

import com.revature.models.ErsReimbursement;
import com.revature.models.ErsUsers;

public class ReimDao implements GenericDao<ErsReimbursement>{

	public ReimPostgres rp = new ReimPostgres();
	
	@Override
	public int add(ErsReimbursement t) {
		return rp.add(t);
		}

		@Override
		public List<ErsReimbursement> getAll() {
			return rp.getAll();
			}

		@Override
		public ErsReimbursement getById(int id) {
			return rp.getById(id);
		}

		@Override
		public boolean update(ErsReimbursement t) {
			return rp.update(t);
		}

		@Override
		public int delete(int id) {
			return rp.delete(id);
		}

		public Collection<ErsReimbursement> getPending() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<ErsReimbursement> getResolved() {
			// TODO Auto-generated method stub
			return null;
		}

		public Collection<ErsReimbursement> getReimByUsername(String username) {
			// TODO Auto-generated method stub
			return null;
		}

}
