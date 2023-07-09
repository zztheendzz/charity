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

import com.example.demo.dao.DateTime;
import com.example.demo.dao.DonationDao;
import com.example.demo.dao.LoginDao;
import com.example.demo.dao.UserDao;
import com.example.demo.dao.UserDonationDao;
import com.example.demo.model.Donation;
import com.example.demo.model.User;
import com.example.demo.model.UserDonation;

import DTO.UserDonationDTO;

@Controller
@RequestMapping("/public")
public class UserController {
	@Autowired
	@Qualifier("DonationDao")
	private DonationDao dd;
	
	@Autowired
	@Qualifier("UserDao")
	private UserDao ud;
	
	@Autowired
	@Qualifier("UserDonationDao")
	private UserDonationDao udd;
	

	

	
	private LoginDao loginD = new LoginDao();
	private User u = new User();
	DateTime dt = new DateTime();
	
	
	
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	@GetMapping("/login")
	public String login() {
		return"admin/login";
	}
	
	@PostMapping("/login")
	public String test(@ModelAttribute("user") User user, Model model) {
		User us = new User();
		boolean error = true;
		int check = loginD.check(user.getUserName(), user.getPassword(), ud.getListUser());
		if (check == 1) {
			
			setU(loginD.getU());
			return "redirect:/ql-user/account";
		} else if (check == 2) {
			us= loginD.user(user.getUserName(), user.getPassword(), ud.getListUser());
			setU(us);
			System.out.println("day la "+us.toString());
			
			model.addAttribute("user", us);
			return "redirect:/public/home";
		} else {
			error = true;
			model.addAttribute("error", error);
		}

		return "admin/login";
		}
	
	@GetMapping("/home")
	public String home(Model model) {
		List<Donation> list= dd.getDonationList();
		model.addAttribute("listdonation", list);
		model.addAttribute("user", getU());
		return "public/home";
	}
	@GetMapping("/detail/{donationId}")
	public String detail(@PathVariable("donationId") int donationId, Model model) {
		List<UserDonation> userDonationList= udd.GetListByIdD(donationId);
		model.addAttribute("userDonationList", userDonationList);
		model.addAttribute("user", getU());
		model.addAttribute("donationId", donationId);
		
		Donation donation = dd.getDonationById(donationId);
		model.addAttribute("donation", donation);

		return "public/detail";
	}

	@PostMapping("/addDonation")
	public String addD( @ModelAttribute("UserDonationDTO") UserDonationDTO userDonationDTO ) {
		UserDonation UD = new UserDonation(userDonationDTO);
		UD.setCreated(dt.getDate());
		System.out.println("test"+UD.toString());
		
		UD.setUser(ud.getUser(u.getId()));
		UD.setDonation(dd.getDonationById(UD.getDonationId()));
		udd.save(UD);
		return"redirect:/public/home";
	}

}
