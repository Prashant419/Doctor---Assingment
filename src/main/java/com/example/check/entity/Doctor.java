package com.example.check.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity(name="abc")
@Table(name="doctors")
public class Doctor {
	@Id
	@Column(name="Did",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Did;
	
	@Column(name="Dname")
	@Size(min=3)
	private String Dname;
	
	@Column(name="Dcity")
	@Size(max=3)
	private String Dcity;
	
	@Column(name="Demail")
	@Email
	private String Demail;
	
	@Column(name="Dphone")
	@Size(min=10)
	private String Dphone;
	
	@Column(name="speciality")
	@Size(max=4)
	private String speciality;
	
	
	public Doctor() {
		super();
	}

	public Doctor(@Size(min = 3) String dname, @Size(max = 20) String dcity, @Email String demail,
			@Size(min = 10) String dphone, String speciality) {
		super();
		Dname = dname;
		Dcity = dcity;
		Demail = demail;
		Dphone = dphone;
		this.speciality = speciality;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public String getDcity() {
		return Dcity;
	}

	public void setDcity(String dcity) {
		Dcity = dcity;
	}

	public String getDemail() {
		return Demail;
	}

	public void setDemail(String demail) {
		Demail = demail;
	}

	public String getDphone() {
		return Dphone;
	}

	public void setDphone(String dphone) {
		Dphone = dphone;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "Doctor [Dname=" + Dname + ", Dcity=" + Dcity + ", Demail=" + Demail + ", Dphone=" + Dphone
				+ ", speciality=" + speciality + "]";
	}
	
	
}
