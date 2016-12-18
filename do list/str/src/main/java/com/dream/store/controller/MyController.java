package com.dream.store.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public ModelAndView isValidUser(@RequestParam(value = "name") String id,
			@RequestParam(value = "password") String password, HttpSession session) {
        
		
		
		ModelAndView mv = new ModelAndView("Home");
		
		
		boolean isValidUser = userDAO.isValidUser(id, password , false);
		mv.addObject("isUserClickedLoginHere", "true");
		if (isValidUser == true) {
			
			mv.addObject("isuser", "true");
			System.out.println(user.getName() + "logged in");
			user = userDAO.get(id);
			session.setAttribute("loggedInUser", user.getId());
			session.setAttribute("user", user);
			System.out.println(user.getId() + "logged in");

			 if (user.isAdmin()) {
		    	 mv.addObject("isAdmin", "true");	
		    	 System.out.println(user.getId() + "admin logged in");
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
	
	
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public ModelAndView newr(@ModelAttribute("task") Task t) {

		ModelAndView mv = new ModelAndView("/new");
		mv.addObject("isnew", "true");
		//model.addAttribute("task", task);
		//model.addAttribute("taskList", this.taskDAO.listTask());
		return mv;
	}
	
	@RequestMapping(value = "/task/delete/{id}")
	public String deleteTask(@PathVariable("id") String id, ModelMap model) {
	
		taskDAO.deleteTask(id);;
		
	
	return "redirect:/pending";
}
	
	
	
	
	@RequestMapping(value = "task/update/{id}")
	public String  editstatus(@PathVariable("id") String id,@ModelAttribute("task") Task t) {
		ModelAndView model=new ModelAndView("/pending");
		task.setId(id);
		t=taskDAO.getTask(id);
		t.setStatus("done");
		//task=taskDAO.getTask(id);
	
		System.out.println("dddddddddddddddddddddddddddddd"+id);
		model.addObject("task", task);
		model.addObject("taskList", this.taskDAO.listTask());
		taskDAO.saveOrUpdateTask(t);

		return "redirect:/pending";
	}
	
	

	
	
	
	
	
	
	
	@RequestMapping("/pending")
	public ModelAndView pending(@ModelAttribute("task") Task t) {

		ModelAndView mv = new ModelAndView("/task");
		mv.addObject("isnewp", "true");
		mv.addObject("taskList", this.taskDAO.listTask());
		return mv;
	}
	
	@RequestMapping("/completed")
	public ModelAndView completed() {

		ModelAndView mv = new ModelAndView("/task");
		mv.addObject("isnewc", "true");
		return mv;
	}
	
	
	
	
	@RequestMapping(value = "/toaddnew", method = RequestMethod.POST)
	public String addTasks(@ModelAttribute("task") Task task)
	{
		System.out.println("insiddddddddddddeeeeeeeeeeeeeeeeeeeeeeeee");
		String newID = Util.removeComma(task.getId());
		task.setId(newID);
		
		taskDAO.saveOrUpdateTask(task);

		return "redirect:/pending";
	}

}
