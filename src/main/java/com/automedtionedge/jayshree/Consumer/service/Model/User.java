package com.automedtionedge.jayshree.Consumer.service.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.automedtionedge.jayshree.Consumer.service.Enum.Role;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity

@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UserId")
	private Long empId;

	@Column(name = "User_Name",unique = true)
	private String name;

	@Column(name = "User_Mobile")
	private String Mobile;

	@Column(name = "User_Password")
	private String password;

	@Column(name = "User_Role")
	private Role role;

	public User() {

	}

	public User(Long empId, String name, String mobile, String password, Role role) {
		super();
		this.empId = empId;
		this.name = name;
		Mobile = mobile;
		this.password = password;
		this.role = role;
	}





	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
}
