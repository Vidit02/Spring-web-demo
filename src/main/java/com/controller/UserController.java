package com.controller;

import java.io.File; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bean.UserBean;
import com.dao.UserDao;
import com.service.UploadService;

@Controller
public class UserController {

	@Autowired
	UploadService uploadService;
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/newprofile")
	public String newProfile() {
		return "NewProfile"; 
	}
	
	@PostMapping("/saveprofile")
	public String saveProfile(UserBean user, @RequestParam("profilepic") MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(user.getEmail());
		boolean isUpload = uploadService.profilePicUpload(file, user.getEmail());
		if(isUpload) {
			user.setProfile(user.getEmail()+"/"+file.getOriginalFilename());
			userDao.inserUser(user);
		}
		
		return "Success";
	}
	
	@GetMapping("/listprofile")
	public String listAllImages(Model model) {
		File f = new File("/Users/vidit/Documents/Royal/Spring Boot/FirstProject/src/main/resources/static");
		String allFiles[] = f.list();
		model.addAttribute("allFiles",allFiles);
		return "AllImg";
	}
}
