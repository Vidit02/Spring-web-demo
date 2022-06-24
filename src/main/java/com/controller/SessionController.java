package com.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bean.UserBean;
 
@Controller
public class SessionController {
	
	//Signup
	@RequestMapping(value =  "/signup",method = RequestMethod.GET)
	public String signup(Model model ) {
		UserBean user = new UserBean();
		model.addAttribute("user", user);
		System.out.println("Signup is called");
		return "Signup"; //Signup.jsp
	}
	
	//Login
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String login() {
		return "Login"; //Login.jsp
	}

	
	//Saveuse
	@RequestMapping(value = "/saveuser" , method = RequestMethod.POST)
	public String saveuser(@ModelAttribute("user") @Valid UserBean user , BindingResult result , Model model) {
		System.out.println(user.getEmail());
		System.out.println(user.getFname());

		model.addAttribute("user",user);
		if(result.hasErrors()) {
			System.out.println("it has errors");
			return "Signup";
		} else {
			System.out.println("it has no errors");
			return "Home";
		}
	}
}
