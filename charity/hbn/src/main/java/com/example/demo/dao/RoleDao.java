package com.example.demo.dao;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Role;

@Repository
@Transactional
@Component("RoleDao")
public class RoleDao {
	@Autowired
	private SessionFactory factory;
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}
		return session;
	}
	public void save(Role role) {
		getSession().save(role);
	} 
	public List<Role> getRoleList(){
		List<Role>  roleList = null;
//		from User => User là tên class, truy vấn theo tên lớp chứ k còn theo tên bảng
		roleList = getSession().createQuery("from Role",Role.class).getResultList();
		return roleList;
	}

}
