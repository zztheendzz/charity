package com.example.demo.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import DTO.DonationDTO;

@Entity
@Table(name = "donation")
public class Donation {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "code")
	private String code;

	@Column(name = "created")
	private String created;

	@Column(name = "description")
	private String description;

	@Column(name = "end_date")
	private String endDate;

	@Column(name = "money")
	private int money;

	@Column(name = "name")
	private String name;

	@Column(name = "organization_name")
	private String organizationName;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "start_date")
	private String startDate;

	@Column(name = "status")
	private int status;

//	@ManyToMany(fetch = FetchType.LAZY,cascade = { CascadeType.ALL })
//	@JoinTable(
//			name 				= "user_donation", 
//			joinColumns			= { @JoinColumn(name = "donation_id",referencedColumnName = "id") }, 
//			inverseJoinColumns	= {@JoinColumn(name = "user_id", referencedColumnName = "id") })

	@OneToMany(mappedBy = "donation")
	private List<UserDonation>userDonationList = new ArrayList<>();
	
	
	
	
	public List<UserDonation> getUserDonationList() {
		return userDonationList;
	}

	public void setUserDonationList(List<UserDonation> userDonationList) {
		this.userDonationList = userDonationList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Donation() {
		

	}

	public Donation(DonationDTO donationDTO) {
		
		id = donationDTO.getId();
		code = donationDTO.getCode();
		created = donationDTO.getCreated();
		description = donationDTO.getDescription();
		endDate = donationDTO.getEndDate();
		money = donationDTO.getMoney();
		name = donationDTO.getName();
		organizationName = donationDTO.getOrganizationName();
		phoneNumber = donationDTO.getPhoneNumber();
		startDate = donationDTO.getStartDate();
		status = donationDTO.getStatus();

	}
	public String datetostring(Date date) {
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = df.format(date);
        return dateString;
	}

}
