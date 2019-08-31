package com.risyst.hibernate.dbservice;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	private static SessionFactory factory = null;
	public static SessionFactory getSessionFactory() {
		try {
			if(factory == null) {
				Configuration cfg = new Configuration();
				factory = cfg.configure().buildSessionFactory();
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return factory;
	}
}
