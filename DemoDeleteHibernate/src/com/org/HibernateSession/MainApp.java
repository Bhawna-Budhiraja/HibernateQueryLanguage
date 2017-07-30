package com.org.HibernateSession;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();

		session.beginTransaction();

		Query query=session.createQuery("delete from Student where id=?");
		query.setParameter(0, 6);
		int a=query.executeUpdate();

		System.out.println("no of records deleted="+a);
		session.getTransaction().commit();
		session.close();
	}

}
