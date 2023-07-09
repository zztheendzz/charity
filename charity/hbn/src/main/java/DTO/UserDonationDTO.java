package DTO;


public class UserDonationDTO {
	

	private int id;
	private String created;
	private int money;
	private String name;
	private int status;
	private String text;
	private int donationId;
	private int userId;


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


	@Override
	public String toString() {
		return "UserDonationDTO [id=" + id + ", created=" + created + ", money=" + money + ", name=" + name
				+ ", status=" + status + ", text=" + text + ", donationId=" + donationId + ", userId=" + userId + "]";
	}



	
	
	
	
	
}
