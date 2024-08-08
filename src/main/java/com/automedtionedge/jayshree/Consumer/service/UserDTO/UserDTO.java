package com.automedtionedge.jayshree.Consumer.service.UserDTO;

import javax.persistence.Column;

import com.automedtionedge.jayshree.Consumer.service.Enum.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class UserDTO {
	private Long EmpId;

	private String Name;

	private String Mobile;

	private String Password;

	private Role role;

	public UserDTO() {

	}

	public UserDTO(Long empId, String name, String mobile, String password, Role role) {
		super();
		EmpId = empId;
		Name = name;
		Mobile = mobile;
		Password = password;
		this.role = role;
	}

	@Override
	public String toString() {
		return "UserDTO [EmpId=" + EmpId + ", Name=" + Name + ", Mobile=" + Mobile + ", Password=" + Password
				+ ", role=" + role + "]";
	}

	public Long getEmpId() {
		return EmpId;
	}

	public void setEmpId(Long empId) {
		EmpId = empId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
