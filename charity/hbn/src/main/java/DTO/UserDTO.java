package DTO;

import javax.persistence.Entity;

import com.example.demo.model.User;



@Entity
public class UserDTO {
	private int id;
	private String userName;
	private String password;
	private String fullName;
	private String email;
	private String address;
	private String phoneNumber;
	private String note;
	private int status;
	private int roleId;
	private String roleName;
	private String created;
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getNote() {
		return note;
	}



	public void setNote(String note) {
		this.note = note;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public int getRoleId() {
		return roleId;
	}



	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}



	public String getRoleName() {
		return roleName;
	}



	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}



	public String getCreated() {
		return created;
	}



	public void setCreatedAt(String created) {
		this.created = created;
	}


	public UserDTO() {

	}

	public UserDTO(User user) {
		id = user.getId();
		userName = user.getUserName();
		password = user.getPassword();
		fullName = user.getFullName();
		email = user.getEmail();
		address = user.getAddress();
		phoneNumber = user.getPhoneNumber();
		note = user.getNote();
		status = user.getStatus();
		roleId = user.getRoleId().getId();
		roleName = user.getRoleId().getName();
		created = user.getCreated();
	}



	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", email=" + email + ", address=" + address + ", phoneNumber=" + phoneNumber + ", note=" + note
				+ ", status=" + status + ", roleId=" + roleId + ", roleName=" + roleName + ", created=" + created + "]";
	}

	
}
