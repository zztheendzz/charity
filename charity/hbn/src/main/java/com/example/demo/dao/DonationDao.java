package com.example.demo.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Donation;

import DTO.DonationDTO;

@Repository
@Transactional
@Component("DonationDao")
public class DonationDao {
	
	
	
	@Autowired
	private SessionFactory factory;
	
	@Autowired
	@Qualifier("UserDonationDao")
	private UserDonationDao udd;
	
	DateTime dt = new DateTime();
	
	public Session getSession() {
		Session session = factory.getCurrentSession();
		if (session == null) {
			session = factory.openSession();
		}

		return session;
	}
//	Lấy ds có status!=4
	public List<Donation> getDonationList(){
			List<Donation>  listDonation = null;
			String hql = " FROM Donation " + "where status != 4";
			System.out.println("id la " );
			Query query =   getSession().createQuery(hql);
			listDonation = query.getResultList();
			for(Donation d: listDonation) {
				d.setMoney(udd.Money(d.getId()));
			}
			return listDonation;
	}
//	  Lấy tất cả danh sách Donation
	public List<Donation> getAllListDonation(){
		List<Donation>  listDonation = null;
//		from User => User là tên class, truy vấn theo tên lớp chứ k còn theo tên bảng
		listDonation = getSession().createQuery("from Donation",Donation.class).getResultList();
		return listDonation;
	}
	
	// thêm mới
		public void saveDonation(DonationDTO donationDTO) {
			Donation donation = new Donation(donationDTO);
			donation.setCreated(dt.getDate());
			donation.setStatus(0);
			getSession().save(donation);
		} 
	// xoá
		public void delete(int id) {
			Donation donation = getDonationById(id);
			donation.setStatus(4);
			update(donation);
		} 
//		 update
		public void update( Donation donation) {
			List<Donation>getListDonation = getDonationList();
			
			System.out.println("cap nhat id" + donation.getId());
			System.out.println("cap nhat size" + getListDonation.size());
			
			for(Donation d : getListDonation ) {
				if(d.getId()==donation.getId()) {
					
				System.out.println("cap nhat id" + d.getId());
				
				getSession().evict(d);
				d = donation;
				getSession().update(d);
				break;
				}
			}
		} 
//		add donation
		public void addDonatio(int idDonation, int idUser ) {
			List<Donation>getListDonation = getDonationList();	
			for(Donation d : getListDonation ) {
				if(d.getId()==idDonation) {

				}
			}

		} 
//		get donation by id
		public Donation getDonationById(int idD){
			List<Donation>  listDonation = null;
			Donation donation = new Donation();
//			from User => User là tên class, truy vấn theo tên lớp chứ k còn theo tên bảng
			listDonation = getSession().createQuery("from Donation",Donation.class).getResultList();
			for(Donation d: listDonation) {
				if(d.getId()==idD) {
					donation = d;
					break;
				}
			}
			return donation;
		}
//		 lock donation 
		public void lockDonation (int idD){
			
			Donation donation = getDonationById(idD);
//			from User => User là tên class, truy vấn theo tên lớp chứ k còn theo tên bảng
			int stt = donation.getStatus() + 1;
			donation.setStatus(stt);
			update(donation);

		}
		
		

}
