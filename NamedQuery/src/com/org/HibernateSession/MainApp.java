package com.org.HibernateSession;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		
	    String id="5";
		Query query=session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, Integer.parseInt(id));
		
		List<Student> student=(List<Student>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		for(Student s:student)
		{
			System.out.println(s.getName());
		}
	}

}
