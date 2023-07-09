package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.DateTime;
import com.example.demo.dao.DonationDao;
import com.example.demo.dao.RoleDao;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserDonationDao;
import com.example.demo.model.Donation;
import com.example.demo.model.User;
import com.example.demo.model.UserDonation;

import DTO.DonationDTO;
import DTO.UserDTO;

@Controller
@RequestMapping("/ql-user")
public class AdminController {
	@Autowired
	@Qualifier("UserDao")
	private UserDao ud;
	
	@Autowired
	@Qualifier("RoleDao")
	private RoleDao rd;
	
	@Autowired
	@Qualifier("DonationDao")
	private DonationDao dd;
	
	@Autowired
	@Qualifier("UserDonationDao")
	private UserDonationDao udd;
	
	DateTime dt = new DateTime();
	
	
	
	@GetMapping("/account")
	public String acconut(Model model) {
		List<User> list = ud.getListUser();
		model.addAttribute("list",list);
		System.out.println(list.size());
		return "admin/account";
	}
	@PostMapping("/account")
	public String addUser(@ModelAttribute("userDTO") UserDTO userDTO) {
		
		userDTO.setCreatedAt(dt.getDate());
		ud.saveUser(userDTO);
		System.out.println("roleid= "+ userDTO.getRoleId() );
		System.out.println("toString= "+ userDTO.toString() );
		return "redirect:/ql-user/account";
	}
	
	@PostMapping("/delete")
	public String deleteUser(@RequestParam("idUser") int idUser) {
		
		System.out.println(idUser);
		ud.delete(idUser);
		return "redirect:/ql-user/account";
	}
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("userDTOUpdate") UserDTO userDTOUpdate) {
		
		System.out.println("cap nhat " + userDTOUpdate);
		User user = new User(userDTOUpdate);
		ud.update(user);
		return "redirect:/ql-user/account";
	}
	@PostMapping("/lock")
	public String lock (@RequestParam("idUser") int idUser) {
		ud.lock_UnlockUser(idUser);
		return "redirect:/ql-user/account";
	}
	@PostMapping("/un-lock")
	public String unlock (@RequestParam("idUser") int idUser) {
		ud.lock_UnlockUser(idUser);
		return "redirect:/ql-user/account";
	}


	
	
//	Donation
	@GetMapping("/donation")
	public String donation(Model model) {
		List<Donation> list = dd.getDonationList();
		model.addAttribute("list",list);
		System.out.println(list.size());
//		System.out.println("day la" + date.toString());
		return "admin/donation";
	}
//	them donation
	@PostMapping("/donation")
	public String addDonation(@ModelAttribute("donationDTO") DonationDTO donationDTO) {
		dd.saveDonation(donationDTO);
		return "redirect:/ql-user/donation";
	}
//	xoá donation
	@PostMapping("/deleteDonation")
	public String deleteDonation(@RequestParam("idDonation") int idDonation) {
		
		System.out.println(idDonation);
		dd.delete(idDonation);
		return "redirect:/ql-user/donation";
	}

// update donation	
	@PostMapping("/updateDonation")
	public String updateDonation(@ModelAttribute("donationDTOUpdate") DonationDTO donationDTOUpdate) {
		
		System.out.println("cap nhat " + donationDTOUpdate);
		Donation donation = new Donation(donationDTOUpdate);
		dd.update(donation);
		return "redirect:/ql-user/donation";
	}
	
	// detail donation	
		@GetMapping("/detail/{donationId}")
		public String DetailDonation(@PathVariable("donationId") int donationId, Model model) {
			
			List<UserDonation> userDonationList = udd.GetListByIdD(donationId);
			Donation donation = dd.getDonationById(donationId);
			model.addAttribute("userDonationList", userDonationList);
			model.addAttribute("donation", donation);
			
			System.out.println("cap nhat " + donationId);
			System.out.println("cap nhat " + donation.getCode());
			
			return "admin/detail";
		}
//		 lock donation
		@PostMapping("/lockDonation")
		public String lockDonation(@RequestParam("idD") int idD) {
			dd.lockDonation(idD);
			return "redirect:/ql-user/donation";
		}
}
