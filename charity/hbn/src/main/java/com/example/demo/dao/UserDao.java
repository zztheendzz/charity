package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;

import DTO.UserDTO;



@Repository
@Transactional
@Component("UserDao")
public class UserDao { 

	@Autowired
	private SessionFactory factory;

	public Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}
// thêm mới
	public void saveUser(UserDTO userDTO) {
		User user = new User(userDTO);
		getSession().save(user);
	} 
	public void saveUser(User user) {
		
		getSession().save(user);
	} 
// xoá
	public void delete(int id) {
		User u = getUser(id);
		u.setStatus(3);
		update(u);
	} 
//	 update
	public void update( User newUser) {
		List<User>getListUser = getListUser();
		
		System.out.println("cap nhat id" + newUser.getId());
		System.out.println("cap nhat size" + getListUser.size());
		
		for(User u : getListUser ) {
			if(u.getId()==newUser.getId()) {
				
			System.out.println("cap nhat id" + u.getId());
			
			getSession().evict(u);
			u = newUser;
			getSession().update(u);
			break;
			}
		}
	} 
//	Lấy ds có status!=3
	public List<User> getListUser(){
		List<User>  listUsers = null;
		String hql = " FROM User " + "where status != 3";
		System.out.println("id la " );
		Query query =   getSession().createQuery(hql);
		listUsers = query.getResultList();
		return listUsers;
	}
//	  Lấy tất cả danh sách user
	public List<User> getAllListUser(){
		List<User>  listUsers = null;
//		from User => User là tên class, truy vấn theo tên lớp chứ k còn theo tên bảng
		listUsers = getSession().createQuery("from User",User.class).getResultList();
		return listUsers;
	}
// Lấy user theo id
	public User getUser(int idUser){
		User user = new User();
		List<User>  getListUser = getSession().createQuery("from User",User.class).getResultList();
//		from User => User là tên class, truy vấn theo tên lớp chứ k còn theo tên bảng
		for(User u : getListUser ) {
		if(u.getId()==idUser) {
			user = u;
		}}
		
		return user;
	}
//	lock
	public void lock_UnlockUser( int idUser) {
		
		for(User u : getListUser()) {
			if(idUser == u.getId()) {
				if(u.getStatus()==0) {
					u.setStatus(1);
				}else {u.setStatus(0); }
				update(u);
				break;
			}
		}
	}



}