package com.tcs.profile_evaluation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profilestatus {
	@Id
	private int id;
	private String status;
	private String comments;
	private String evalname;
	
	public String getEvalname() {
		return evalname;
	}
	public void setEvalname(String evalname) {
		this.evalname = evalname;
	}
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
