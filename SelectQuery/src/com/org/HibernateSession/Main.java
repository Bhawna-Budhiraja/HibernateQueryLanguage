package com.org.HibernateSession;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
        session.beginTransaction();
        
		Query userList=session.createQuery("from UserDetails");
		
		List list=userList.list();

		session.getTransaction().commit();
		session.close();
		System.out.println("size of list="+list.size());
	}

}
