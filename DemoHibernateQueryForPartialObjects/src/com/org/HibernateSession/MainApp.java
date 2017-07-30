package com.org.HibernateSession;

import java.util.Iterator;
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

		Query query=session.createQuery("Select s.id,s.name from Student s");
		List list=query.list();

		Iterator itr=list.iterator();
		while(itr.hasNext())
		{
			Object[] stObj=(Object[])itr.next();
			System.out.println(stObj[0]);
			System.out.println(stObj[1]);
			System.out.println("********************************");

		}
		session.getTransaction().commit();
		session.close();



	}

}
