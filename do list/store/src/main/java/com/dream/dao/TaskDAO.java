package com.dream.dao;

import java.util.List;

import com.dream.module.Task;

public interface TaskDAO {
	
	void saveOrUpdateTask(Task task);
	void deleteTask(String id);
	Task getTask(String id);
	List<Task> listTask();

}
