package com.tcs.profile_evaluation.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;


import com.sun.istack.NotNull;

import javax.persistence.JoinColumn;


@Entity
public class Profile {
	@Id
	private int id;
	@NotEmpty(message = "Vendor is mandatory")
	private String vendor;
	@NotEmpty(message = "Name is mandatory")
	private String name;
	@NotNull()
	private Long mobileno;
	@NotEmpty(message = "Location is mandatory")
	private String location;
	@NotNull()
	@DecimalMin("1.00")
	private Float experience;
	@NotEmpty(message = "Skill1 is mandatory")
	private String skill1;
	private String skill2;
	private LocalDate date;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private Profilestatus profilestatus;
	
	
	public Profilestatus getStatus() {
		return profilestatus;
	}
	public void setStatus(Profilestatus status) {
		this.profilestatus = status;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDate getDate() {
		return date;
	}
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
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long long1) {
		this.mobileno = long1;
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
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

}