package com.example.check.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name="patients")
public class Patient {
	@Id
	@Column(name="Pid",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Pid;
	
	@Column(name="Pname")
	@Size(min=3)
	private String Pname;
	
	@Column(name="Pcity")
	@Size(max=20)
	private String Pcity;
	
	@Column(name="Pemail")
	@Email
	private String Pemail;
	
	@Column(name="Pphone")
	@Size(min=10)
	private String Pphone;
	
	@Column(name="symptom")
	private String symptom;
	
	
	public Patient() {
		super();
	}

	public Patient(@Size(min = 3) String pname, @Size(max = 20) String pcity, @Email String pemail,
			@Size(min = 10) String pphone, String symptom) {
		super();
		Pname = pname;
		Pcity = pcity;
		Pemail = pemail;
		Pphone = pphone;
		this.symptom = symptom;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public String getPcity() {
		return Pcity;
	}

	public void setPcity(String pcity) {
		Pcity = pcity;
	}

	public String getPemail() {
		return Pemail;
	}

	public void setPemail(String pemail) {
		Pemail = pemail;
	}

	public String getPphone() {
		return Pphone;
	}

	public void setPphone(String pphone) {
		Pphone = pphone;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	@Override
	public String toString() {
		return "Patient [Pname=" + Pname + ", Pcity=" + Pcity + ", Pemail=" + Pemail + ", Pphone=" + Pphone
				+ ", symptom=" + symptom + "]";
	}
	
	
	
}
