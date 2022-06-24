package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bean.RoleBean;
import com.dao.RoleDao;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class RoleController {

	@Autowired
	RoleDao roleDao;

	@GetMapping("/newrole") // Get Mapping that is used to get role inputs from jsp
	public String newRole(Model model) {
		model.addAttribute("role", new RoleBean());
		return "NewRole"; // NewRole jsp is called here
	}

	@PostMapping("/saverole")
	public String saverole(@ModelAttribute("role") @Valid RoleBean role, BindingResult result, Model model) {
		System.out.println("Name of role : " + role.getRoleName());
		model.addAttribute("role", role);
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
			System.out.println(result.getFieldErrorCount());
			System.out.println(result.getAllErrors());
			return "NewRole";
		} else {
			// We will insert the new role into the database
			roleDao.insertRole(role);
			List<RoleBean> roles = roleDao.getAllRoles();
			model.addAttribute("roles",roles);
			return "ListRoles";
		}
	}
	
	@GetMapping("/listrole")
	public String listroles(Model model) {
		List<RoleBean> roles = roleDao.getAllRoles();
		model.addAttribute("roles",roles);
		return "ListRoles";
	}
	
	@RequestMapping(value = "/deleterole" , method = RequestMethod.GET)
	public String deleteRole(@RequestParam int userid,Model model) {
		System.out.println(userid);
		roleDao.deleterole(userid);
		List<RoleBean> role = roleDao.getAllRoles();
		model.addAttribute("roles",role);
		return "ListRoles";
	}
	
	@GetMapping("/viewrole")
	public String viewRole(@RequestParam("roleid") int roleid,Model model) {
		RoleBean role = roleDao.getRoleById(roleid);
		model.addAttribute("role",role);
		return "ViewRole";
	}

}