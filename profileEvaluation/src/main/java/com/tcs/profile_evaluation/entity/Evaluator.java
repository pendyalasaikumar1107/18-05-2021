package com.tcs.profile_evaluation.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@SuppressWarnings("unused")
@Entity
public class Evaluator {
	@Id
    private int evalid;
	private String evalname;
	private Long mobileno;
	private String mail;
	
	public int getEvalid() {
		return evalid;
	}
	public void setEvalid(int evalid) {
		this.evalid = evalid;
	}
	public String getEvalname() {
		return evalname;
	}
	public void setEval_name(String evalname) {
		this.evalname = evalname;
	}
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileNo(Long mobileno) {
		this.mobileno = mobileno;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	
}
