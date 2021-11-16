package com.revature.models;

import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Objects;

public class ErsReimbursement {
	private int id;
	private double amount;
	private Timestamp submitted;
	private Timestamp resolved;
	private String description;
	private Blob recipt;
	private ErsUsers author;
	private ErsUsers resolver;
	private ErsStatus status_Id;
	private ErsType type_Id;
	
	
	public ErsReimbursement() {
		super();
	}

	public ErsReimbursement(int id, double amount, Timestamp submitted, Timestamp resolved, String description,
			Blob recipt, ErsUsers author, ErsUsers resolver, ErsStatus status_Id, ErsType type_Id) {
		super();
		this.id = id;
		this.amount = amount;
		this.submitted = submitted;
		this.resolved = resolved;
		this.description = description;
		this.recipt = recipt;
		this.author = author;
		this.resolver = resolver;
		this.status_Id = status_Id;
		this.type_Id = type_Id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public Timestamp isSubmitted() {
		return submitted;
	}


	public void setSubmitted(Timestamp submitted) {
		this.submitted = submitted;
	}


	public Timestamp isResolved() {
		return resolved;
	}


	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Blob getRecipt() {
		return recipt;
	}


	public void setRecipt(Blob recipt) {
		this.recipt = recipt;
	}


	public ErsUsers getAuthor() {
		return author;
	}


	public void setAuthor(ErsUsers author) {
		this.author = author;
	}


	public ErsUsers getResolver() {
		return resolver;
	}


	public void setResolver(ErsUsers resolver) {
		this.resolver = resolver;
	}


	public ErsStatus getErsStatus_Id() {
		return status_Id;
	}


	public void setErsStatus_Id(ErsStatus status_Id) {
		this.status_Id = status_Id;
	}


	public ErsType getErsType_Id() {
		return type_Id;
	}


	public void setErsType_Id(ErsType type_Id) {
		this.type_Id = type_Id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, author, description, id, recipt, resolved, resolver, status_Id, submitted, type_Id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ErsReimbursement other = (ErsReimbursement) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(author, other.author) && Objects.equals(description, other.description)
				&& id == other.id && Objects.equals(recipt, other.recipt) && resolved == other.resolved
				&& Objects.equals(resolver, other.resolver) && Objects.equals(status_Id, other.status_Id)
				&& submitted == other.submitted && Objects.equals(type_Id, other.type_Id);
	}


	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", amount=" + amount + ", submitted=" + submitted + ", resolved=" + resolved
				+ ", description=" + description + ", recipt=" + recipt + ", author=" + author + ", resolver="
				+ resolver + ", status_Id=" + status_Id + ", type_Id=" + type_Id + "]";
	}
	
	

}
