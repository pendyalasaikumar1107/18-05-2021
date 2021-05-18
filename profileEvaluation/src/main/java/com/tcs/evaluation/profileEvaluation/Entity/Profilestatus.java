package com.tcs.evaluation.profileEvaluation.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profilestatus {
	@Id
	private int id;
	private String status;
	private String comments;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

}
