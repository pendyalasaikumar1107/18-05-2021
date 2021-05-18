package com.tcs.evaluation.profileEvaluation.Entity;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Profile {
	@Id
	private int id;
	private String vendor;
	private String name;
	private String mobileno;
	private String location;
	private Float experience;
	private String skill1;
	private String skill2;
	private String skill3;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private String date;
	
	@OneToOne
    @JoinTable(name = "evaluatorassigned",
    joinColumns =
      {@JoinColumn(name = "id", referencedColumnName = "id") },
    inverseJoinColumns =
      {@JoinColumn(name = "evalid", referencedColumnName = "evalid") })
    private Evaluator evaluator;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Float getExperience() {
		return experience;
	}
	public void setExperience(Float experience) {
		this.experience = experience;
	}
	public String getSkill1() {
		return skill1;
	}
	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}
	public String getSkill2() {
		return skill2;
	}
	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}
	public String getSkill3() {
		return skill3;
	}
	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}