package com.mh.employee.dto;

public class Employee {

	private String employeeName;
	
	private String address;
	
	private String phone;
	
	private String email;

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", address=" + address + ", phone=" + phone + ", email="
				+ email + "]";
	}
	
	
	
	
}
