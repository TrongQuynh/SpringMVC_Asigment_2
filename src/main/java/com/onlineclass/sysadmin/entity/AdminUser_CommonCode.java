package com.onlineclass.sysadmin.entity;

import java.sql.Timestamp;

public class AdminUser_CommonCode {
	private int ID;
	private String name;
	private String email;
	private int statusCD;
	private String status;
	private String statusColor;
	private String notes;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	private Timestamp deletedAt;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getStatusCode() {
		return statusCD;
	}
	public void setStatusCode(int statusCode) {
		this.statusCD = statusCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Timestamp getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	public int getStatusCD() {
		return statusCD;
	}
	public void setStatusCD(int statusCD) {
		this.statusCD = statusCD;
	}
	public String getStatusColor() {
		return statusColor;
	}
	public void setStatusColor(String statusColor) {
		this.statusColor = statusColor;
	}
	@Override
	public String toString() {
		return "AdminUser_CommonCode [ID=" + ID + ", name=" + name + ", email=" + email + ", statusCode=" + statusCD
				+ ", status=" + status + ", notes=" + notes + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", deletedAt=" + deletedAt + "]";
	}
	
	
}
