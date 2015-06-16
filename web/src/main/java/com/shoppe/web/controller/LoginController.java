package com.shoppe.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView adminPage() { 
		ModelAndView model = new ModelAndView();
		model.setViewName("users"); 
		return model;	
	}

	/*@RequestMapping("/login")
	public ModelAndView doLogin(HttpServletRequest request, HttpServletResponse res) {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String message = "Login failed";
		User user = userService.findUser(userName);
		if (userName.equalsIgnoreCase(user.getUserName()) && password.equals(user.getPassword())) {
			message = "Login successful";
			return new ModelAndView("users", "message", message);
		} else {
			return new ModelAndView("error", "message", message);
		}
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String renderLogin(HttpServletRequest request, HttpServletResponse res) {
		return "login";
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
		String message = "Sign Up Successful";
		if (savedUser.equals(null)) {
			message = "Sign Up failed";
			return new ModelAndView("error", "message", message);
		} else {
			return new ModelAndView("users", "message", message);
		}
	}

	@RequestMapping("/report")
	public ModelAndView getUsers(HttpServletRequest request, HttpServletResponse response) {
		List<User> list = userService.getUsers();
		String message = list.toString();
		return new ModelAndView("report", "message", message);

	}

}
