package com.dream.store;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dream.dao.TaskDAO;
import com.dream.module.Task;

public class TaskTest {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.dream");
		context.refresh();
		
		TaskDAO taskDAO = (TaskDAO) context.getBean("taskDAO");
		Task task = (Task) context.getBean("task");
		
		
		task.setId("ts1");
		task.setTask("no ya");
		task.setDescription("ajyaclcdldu");
		task.setStatus("pending");
		
		taskDAO.saveOrUpdateTask(task);
		
		if(taskDAO.getTask("id1")==null)
		{
			System.out.println("task does not exist");
			
		}
		else
		{
			System.out.println("task exist");
			System.out.println();
		}
	

	}

}
