package com.dream.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dream.module.Task;
@Repository("taskDAO")
public class TaskDAOImpl implements TaskDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	
	public TaskDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdateTask(Task task){
	Session s=sessionFactory.getCurrentSession();
	s.saveOrUpdate(task);
	s.flush();
	}
	
	@Transactional
	public void deleteTask(String id){
		Task taskdelete = new Task();
		taskdelete.setId(id);
		sessionFactory.getCurrentSession().delete(taskdelete);
	}
	
	@Transactional
	public Task getTask(String id){
		String hql = "from Task where id=:id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql).setParameter("id",id);
		List<Task> gotTask = query.getResultList();
		if(gotTask!=null&&!gotTask.isEmpty())
			return gotTask.get(0);
		return null;
	}

	@Transactional
	public List<Task> listTask() {
		String hql = "from Task";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Task> listOfTask = query.getResultList();
		return listOfTask;
	}
}