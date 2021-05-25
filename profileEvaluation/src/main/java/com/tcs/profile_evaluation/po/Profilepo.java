package com.tcs.profile_evaluation.po;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class Profilepo {
	
	
	private int id;
	@NotEmpty(message = "Vendor is mandatory")
	private String vendor;
	@NotEmpty(message = "Name is mandatory")
	private String name;
	@NotNull
	@Min(1000000000)
	private Long mobileno;
	@NotEmpty(message = "Location is mandatory")
	private String location;
	@NotNull
	@DecimalMin("1.00")
	private Float experience;
	@NotEmpty(message = "Skill1 is mandatory")
	private String skill1;
	private String skill2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
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
	
	
}
