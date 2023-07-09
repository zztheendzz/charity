package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.UserDonation;

@Repository
@Transactional
@Component("UserDonationDao")
public class UserDonationDao {
	
	@Autowired
	private SessionFactory factory;
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}

		return session;
	}
	public void save(UserDonation userDonation) {
		getSession().save(userDonation);
	}
	public List<UserDonation> getUserDonationlist(){
		List<UserDonation>  listUserDonation = null;
//		from User => User là tên class, truy vấn theo tên lớp chứ k còn theo tên bảng
		listUserDonation = getSession().createQuery("from UserDonation",UserDonation.class).getResultList();
		return listUserDonation;
	}
//	get total money
	
	public int Money(int idDonation) {
		int total = 0;
		List<UserDonation>  listUserDonation = GetListByIdD(idDonation);
		for(UserDonation ud : listUserDonation) {
			total = total+ ud.getMoney();
			
		}
		return total;
	}
	public List<UserDonation> GetListByIdD(int idDonation) {
		
		String hql = "from UserDonation " + "where donation_id =: idDonation";
		System.out.println("id la " + idDonation);
		 Query query =   getSession().createQuery(hql);

		query.setParameter("idDonation", idDonation);
		List<UserDonation>  listUserDonation = query.getResultList();
		return listUserDonation;
	}
	

}
