package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import DTO.UserDonationDTO;

@Entity
@Table(name="user_donation")
public class UserDonation {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="created")
	private String created;
	
	@Column(name="money")
	private int money;
	
	@Column(name="name")
	private String name;
	
	@Column(name="status")
	private int status;
	
	@Column(name="text")
	private String text;
	
	@Column(name="donation_id")
	private int donationId;
	
	@Column(name="user_id")
	private int userId;
	
    @ManyToOne(optional=false)
    @JoinColumn(name = "donation_id", referencedColumnName="id",insertable=false, updatable=false)
    Donation donation;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "user_id", referencedColumnName="id",insertable=false, updatable=false)
    User user;

    
    
	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getDonationId() {
		return donationId;
	}

	public void setDonationId(int donationId) {
		this.donationId = donationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserDonation() {

	}
	public UserDonation(UserDonationDTO udDTO) {
		setId(udDTO.getId());
		setCreated(udDTO.getCreated());
		setMoney(udDTO.getMoney());
		setName(udDTO.getName());
		setStatus(udDTO.getStatus());
		setText(udDTO.getText());
		setDonationId(udDTO.getDonationId());
		setUserId(udDTO.getUserId());
	}
	


	public UserDonation(int id, String created, int money, String name, int status, String text, int donationId,
			int userId) {
		super();
		this.id = id;
		this.created = created;
		this.money = money;
		this.name = name;
		this.status = status;
		this.text = text;
		this.donationId = donationId;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDonation [id=" + id + ", created=" + created + ", money=" + money + ", name=" + name + ", status="
				+ status + ", text=" + text + ", donationId=" + donationId + ", userId=" + userId + "]";
	}
	
	
}
