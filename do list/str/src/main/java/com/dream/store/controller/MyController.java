package com.dream.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dream.dao.TaskDAO;
import com.dream.dao.UserDAO;
import com.dream.module.Task;
import com.dream.module.User;

@Controller
public class MyController {
	
	@Autowired
	User user;
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	Task task;
	
	@Autowired
	TaskDAO taskDAO;
	
	@RequestMapping("/")
	public ModelAndView myfun1(HttpSession session)
	{
	 
	  ModelAndView mv=new ModelAndView("/Home");
	
	  return mv;
		
	}
	
	@RequestMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("/register");
		mv.addObject("user", user);
		mv.addObject("isUserClickedRegisterHere", "true");
		return mv;
	}	
	
	@RequestMapping(value = "here/register", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute User user) {
	    userDAO.saveOrUpdate(user);
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("successMessage", "You are successfully register");

		return "/Home";
	}
	
	
	@RequestMapping("/login")
	public ModelAndView isValidUser(@RequestParam(value = "name") String name,
			@RequestParam(value = "password") String password, HttpSession session) {
        
		
		
		ModelAndView mv = new ModelAndView("Home");
		System.out.println("inside loginnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
		System.out.println(user.getName() + "logged in");
		
		boolean isValidUser = userDAO.isValidUser(name, password , false);
		mv.addObject("isUserClickedLoginHere", "true");
		if (isValidUser == true) {
			
			
			System.out.println(user.getName() + "logged in");
			user = userDAO.get(name);
			session.setAttribute("loggedInUser", user.getName());
			session.setAttribute("user", user);
			System.out.println(user.getName() + "logged in");

			 if (user.isAdmin()) {
		    	 mv.addObject("isAdmin", "true");	
		    	 System.out.println(user.getName() + "admin logged in");
				 }
				else {
			 mv.addObject("isAdmin", "false");
			 
				 }

			} else {

			mv.addObject("invalidCredentials", "true");
			mv.addObject("errorMessage", "Invalid Credentials");

		
		}
		return mv;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpSession session) {
		ModelAndView mv = new ModelAndView("Home");
		session.invalidate();
		session = request.getSession(true);
		
		mv.addObject("logoutMessage", "You successfully logged out");
		mv.addObject("loggedOut", "true");
	
		return mv;
	 }
	
	
	
	@RequestMapping("/new")
	public ModelAndView newr() {

		ModelAndView mv = new ModelAndView("/task");
		mv.addObject("isnew", "true");
		return mv;
	}
	
	@RequestMapping("/pending")
	public ModelAndView pending() {

		ModelAndView mv = new ModelAndView("/task");
		mv.addObject("isnewp", "true");
		return mv;
	}
	
	@RequestMapping("/completed")
	public ModelAndView completed() {

		ModelAndView mv = new ModelAndView("/task");
		mv.addObject("isnewc", "true");
		return mv;
	}
	
	
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String liString(Model model) {
		
		model.addAttribute("task", task);
		model.addAttribute("taskList", this.taskDAO.listTask());
		return "task";
	}
	
	
	
	
	@RequestMapping(value = "/to_add_new", method = RequestMethod.POST)
	public String addTasks(@ModelAttribute("task") Task task)
	{
		String newID = Util.removeComma(task.getId());
		task.setId(newID);
		
		taskDAO.saveOrUpdateTask(task);

		return "redirect:/new";
	}

}
