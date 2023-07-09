package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import DTO.UserDTO;



@Entity
@Table(name = "User")

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "address")
	private String address;
	
	@Column(name = "email")
	private String email;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "note")
	private String note;

	@Column(name = "password")
	private String password;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "status")
	private int status;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "created")
	private String created;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role roleId;
	
	@OneToMany(mappedBy = "user")
	private List<UserDonation>userDonationList = new ArrayList<>();

//	@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
//	@JoinTable(
//			name 				= "user_donation", 
//			joinColumns			= { @JoinColumn(name = "user_id",referencedColumnName = "id") }, 
//			inverseJoinColumns	= {@JoinColumn(name = "donation_id",referencedColumnName = "id") })

	
	

	public int getId() {
		return id;
	}

	public List<UserDonation> getUserDonationList() {
		return userDonationList;
	}

	public void setUserDonationList(List<UserDonation> userDonationList) {
		this.userDonationList = userDonationList;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Role getRoleId() {
		return roleId;
	}

	public void setRoleId(Role roleId) {
		this.roleId = roleId;
	}

	public User() {

	}
	public User(UserDTO userDTO) {
			Role role = new Role();
			this.setRoleId(role);
			id = userDTO.getId();
			userName = userDTO.getUserName();
			password = userDTO.getPassword();
			fullName = userDTO.getFullName();
			email = userDTO.getEmail();
			address = userDTO.getAddress();
			phoneNumber = userDTO.getPhoneNumber();
			note = userDTO.getNote();
			status = userDTO.getStatus();
			roleId.setId(userDTO.getRoleId()) ;
			roleId.setName(userDTO.getRoleName())  ;
			created = userDTO.getCreated();

	}

	@Override
	public String toString() {
		return "User [id=" + id + ", address=" + address + ", email=" + email + ", fullName=" + fullName + ", note="
				+ note + ", password=" + password + ", phoneNumber=" + phoneNumber + ", status=" + status
				+ ", userName=" + userName + ", created=" + created + "]";
	}
	

}
