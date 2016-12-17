package com.dream.store;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dream.dao.UserDAO;
import com.dream.module.User;

public class UserTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.dream");
		context.refresh();
		UserDAO userDAO = (UserDAO) context.getBean("userDao");
		User user = (User) context.getBean("user");
		
		
		user.setId("us1");
		user.setPassword("1234");
		user.setName("user");
		user.setAdmin(false);
	    userDAO.saveOrUpdate(user);
		
	    
	    if(userDAO.get("us1")== null)
		{
			System.out.println(" does not exist");
		}
		else
		{
			System.out.println(" exists..");
			System.out.println();
		} 


	}

}
