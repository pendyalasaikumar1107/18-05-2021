package com.tcs.evaluation.profileEvaluation.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Evaluatorassigned {
	@Id
  private int id;
  private String evalname;
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
public void setEval_name(String evalname) {
	this.evalname = evalname;
}
public int getEvalid() {
	return evalid;
}
public void setEvalid(int evalid) {
	this.evalid = evalid;
}
}
