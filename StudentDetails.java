package com.gl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="studentdetails")
public class StudentDetails {

	@Id
	@Column(name = "id")
	private int studentId;
	@Column(name = "name")
	private String Name;
	@Column(name = "department")
	private String Department;
	@Column(name = "country")
	private String Country;
	
	
	public StudentDetails() {
		super();
	}


	public StudentDetails(String name, String department, String country) {
		super();
		this.studentId = studentId;
		Name = name;
		Department = department;
		Country = country;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public String getDepartment() {
		return Department;
	}


	public void setDepartment(String department) {
		Department = department;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	@Override
	public String toString() {
		return "StudentDetails [studentId=" + studentId + ", Name=" + Name + ", Department=" + Department + ", Country="
				+ Country + "]";
	}
	
	
	
}
