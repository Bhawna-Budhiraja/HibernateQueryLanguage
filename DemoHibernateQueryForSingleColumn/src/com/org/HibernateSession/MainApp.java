package com.org.HibernateSession;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;


public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();

		session.beginTransaction();

		Query query=session.createQuery("Select s.name from Student s");
		List<String> list=(List<String>)query.list();
		session.getTransaction().commit();
		session.close();

		for(String s:list)
		{
			System.out.println(s);
		}
	}

}
