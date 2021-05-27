package com.tcs.profile_evaluation.po;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EvaluatorAssignedPo {
	@NotNull(message="Profile id can't be empty")
	  private int id;
	@NotEmpty(message="Evauator name can't be empty")
	  private String evalname;
	@NotNull(message="Evaluator id can't be empty")
	  private int evalid;
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEvalname() {
		return evalname;
	}
	public void setEvalname(String evalname) {
		this.evalname = evalname;
	}
	public int getEvalid() {
		return evalid;
	}
	public void setEvalid(int evalid) {
		this.evalid = evalid;
	}

}
