package com.shoppe.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoppe.persistence.entity.User;
import com.shoppe.service.base.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	  @RequestMapping("/welcome")
	  public ModelAndView home(HttpServletRequest request, HttpServletResponse res) {
			  return new ModelAndView("login");
	  }
	  
	  @RequestMapping("/login")
	  public ModelAndView login(HttpServletRequest request, HttpServletResponse res) {
		  String name = request.getParameter("name");
		  String password = request.getParameter("password");
		  String message = "Login failed";
		  if(name.equalsIgnoreCase("narender")){
			  message = "Login successful";
			  return new ModelAndView("home", "message", message);
		  }
		  else{
			  return new ModelAndView("error","message",message);
		  }
	  }
	  
	  @RequestMapping("users")
	  public ModelAndView getUsers(HttpServletRequest request, HttpServletResponse response){
		  List<User> list = userService.getUser();
		  String message = list.toString();
		  return new ModelAndView("users", "message", message);
		  
	  }

}
