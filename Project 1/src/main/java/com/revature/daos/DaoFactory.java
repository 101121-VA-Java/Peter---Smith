package com.revature.daos;

public class DaoFactory {


	private static DaoFactory df;
	private UserDao ud;
	private ReimDao rd;
	
	// because of the private access modifier, other classes cannot create instances of DaoFactory
	private DaoFactory() {}
	
	// other classes have to use static method to retrieve a daoFactory instance
	public static synchronized DaoFactory getDaoFactory() {
		if(df == null) {
			df = new DaoFactory();
		}
		return df;
	}
	
	public UserDao getUserDao() {
		// Always return the same instance of EmployeeDao implementation when getEmployeeDao is called
		if(ud == null) {
			// if trying to change implementation to Oracle or mySQL can only change it in one place in my code
			ud = new UserPostgres();
		}
		return ud;
	}
	
	public ReimDao getReimDao() {
		// Always return the same instance of EmployeeDao implementation when getEmployeeDao is called
		if(rd == null) {
			// if trying to change implementation to Oracle or mySQL can only change it in one place in my code
			rd = new ReimPostgres();
		}
		return rd;
	}
	
}
