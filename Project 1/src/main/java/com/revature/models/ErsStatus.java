package com.revature.models;

import java.util.Objects;

public class ErsStatus {
	private int id;
	private String status;
	
	
	public ErsStatus() {
		super();
	}
	
	public ErsStatus(int id, String status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getErsStatus() {
		return status;
	}
	public void setErsStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsStatus other = (ErsStatus) obj;
		return id == other.id && Objects.equals(status, other.status);
	}
	@Override
	public String toString() {
		return "ErsStatus [id=" + id + ", status=" + status + "]";
	}
	
	
	
}
