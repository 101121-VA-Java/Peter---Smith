package com.revature.daos;

import java.util.List;

import com.revature.models.Payment;

public class PaymentDao implements GenericDao<Payment> {

	PaymentPostgres pp = new PaymentPostgres();
	
	@Override
	public int add(Payment t) {
		return (pp.add(t));
	}

	@Override
	public List<Payment> getAll() {
		return (pp.getAll());
	}

	@Override
	public Payment getById(int id) {
		return (pp.getById(id));
	}

	@Override
	public boolean update(Payment t) {
		return (pp.update(t));
	}

	@Override
	public int delete(int id) {
		return (pp.delete(id));
	}

	
	
}
