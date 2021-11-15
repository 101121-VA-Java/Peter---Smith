package com.revature.models;

import java.util.Objects;

public class ErsType {
	private int id;
	private String type;
	
	
	public ErsType() {
		super();
	}
	
	public ErsType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getErsType() {
		return type;
	}
	public void setErsType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, type);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsType other = (ErsType) obj;
		return id == other.id && Objects.equals(type, other.type);
	}
	@Override
	public String toString() {
		return "ErsType [id=" + id + ", type=" + type + "]";
	}
	
	
}
