package com.revature.models;

public class User {

//	protected static int numberOfUsers = 1;     TODO do I need this?  will DB do this for me?
    private int id;
    private String name;
    private String username;
    private String password;
   	private String role;
    private int managerid;
//    private ItemDao shoppingCart;   not needed.  adding junction table for this

    
	public User() {
		super();
		
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public User(String name, String username, String password, int managerid) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.managerid = managerid;
	}

	 public User(int id, String name, String username, String password, String role, int managerid) {
			super();
			this.id = id;
			this.name = name;
			this.username = username;
			this.password = password;
			this.role = role;
			this.managerid = managerid;
		}
	 
	 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManagerid() {
		return managerid;
	}

	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	
    
}
