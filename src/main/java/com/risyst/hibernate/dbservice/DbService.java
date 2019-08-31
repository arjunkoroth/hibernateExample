package com.risyst.hibernate.dbservice;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.risyst.hibernate.model.Users;

public class DbService {
	private SessionFactory factory = null;
	private Session session = null;
	private Transaction tx = null;

	public DbService() {
		factory = HibernateConfig.getSessionFactory();
	}

	// Save a user
	public int saveUser(Users user) {
		int Id = 0;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Id = (Integer) session.save(user);
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (tx != null)
				tx.commit();
			if (session != null)
				session.close();
		}
		return Id;
	}

	// Delete a user
	public void deleteUser(Users user) {
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.delete(user);
			System.out.println("Deleted user with user id - " + user.getUserId());
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (tx != null)
				tx.commit();
			if (session != null)
				session.close();
		}
	}

	// Update a user
	public void updateUser(Users user) {
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.update(user);
			System.out.println("Updated user with user id - " + user.getUserId());
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			if (tx != null)
				tx.commit();
			if (session != null)
				session.close();
		}
	}
	
	// Select Users
	@SuppressWarnings({ "deprecation", "unchecked", "rawtypes" })
	public List<Users> getUsers(){
		List<Users> list = new ArrayList<Users>();
		try {
			session = factory.openSession();
			Query query = session.createQuery("FROM Users");
			list = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null)
				session.close();
		}
		return list;
	}
}
