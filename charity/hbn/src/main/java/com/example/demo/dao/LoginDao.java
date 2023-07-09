package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.User;



public class LoginDao {
	private User u = new User();
	


	public User getU() {
		return u;
	}



	public void setU(User u) {
		this.u = u;
	}



	public int check(String userName, String password, List<User> userList) {
		
		for (int i = 0; i < userList.size(); i++) {
			if (userName.equals(userList.get(i).getUserName()) && password.equals(userList.get(i).getPassword())) {
				setU(userList.get(i));
				return userList.get(i).getRoleId().getId();
			}
		}
		 return 0;
	}
	public User user(String userName, String password, List<User> userList) {
		
		User user = new User();

		for (int i = 0; i < userList.size(); i++) {
			if (userName.equals(userList.get(i).getUserName()) && password.equals(userList.get(i).getPassword())) {
				setU(userList.get(i));
				user = userList.get(i);
				break;
			}
		}
		return user;

	}
}
