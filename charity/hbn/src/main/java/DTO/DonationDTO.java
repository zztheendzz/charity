package DTO;

public class DonationDTO {

	private int id;
	private String code;
	private String created;
	private String description;
	private String startDate;
	private String endDate;
	private int money ;	
	private String name;	
	private String organizationName;
	private String phoneNumber;

	private int status;
	
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


	@Override
	public String toString() {
		return "DonationDTO [id=" + id + ", code=" + code + ", created=" + created + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", money=" + money + ", name=" + name
				+ ", organizationName=" + organizationName + ", phoneNumber=" + phoneNumber + ", status=" + status
				+ "]";
	}
	
	

}
