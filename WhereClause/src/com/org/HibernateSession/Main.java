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

		//here starts pagination
		Query query=session.createQuery("from UserDetails");
		query.setFirstResult(5);
		query.setMaxResults(15);

		List<UserDetails> users=(List<UserDetails>)query.list();
		session.getTransaction().commit();
		session.close();

		for(UserDetails u:users)
			System.out.println(u.getName());
	}

}
