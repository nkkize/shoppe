package com.shoppe.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shoppe.persistence.entity.User;
import com.shoppe.service.base.UserService;
import com.shoppe.service.util.UserUtil;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserUtil userUtil;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView loginSuccess(HttpServletRequest request, HttpServletResponse res) { 
		ModelAndView model = new ModelAndView();
		model.setViewName("home"); 
		return model;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView  renderLogin(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/403")
	public ModelAndView doError(HttpServletRequest request, HttpServletResponse res) {
		ModelAndView model = new ModelAndView();
		model.addObject("title", "can't access protected area");
		model.addObject("message", "You are not authorized to access the protected area!!");
		model.setViewName("admin"); 
		return model;
	}

	@RequestMapping("/newUser")
	public ModelAndView signUp(HttpServletRequest request, HttpServletResponse res) {
		return new ModelAndView("signup");
	}

	@RequestMapping("/signup")
	public ModelAndView doSignUp(HttpServletRequest request, HttpServletResponse res) {
		User user = userUtil.reuestToUser(request);
		User savedUser = userService.saveNewUser(user);
		ModelAndView model = new ModelAndView();
		model.setViewName("admin"); 
		if (savedUser.equals(null)) {
			model.addObject("title", "Sign Up failed");
			model.addObject("message", "Sign Up failed!!");
			return model;
		} else {
			model.addObject("title", "Sign Up Successful");
			model.addObject("message", "Sign Up Successful!!");
			return model;
		}
	}

	@RequestMapping("/report")
	public ModelAndView getUsers(HttpServletRequest request, HttpServletResponse response) {
		List<User> list = userService.getUsers();
		String message = list.toString();
		return new ModelAndView("report", "message", message);

	}

}
