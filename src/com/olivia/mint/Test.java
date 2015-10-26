package com.olivia.mint;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.olivia.mint.model.Address;
import com.olivia.mint.model.UserDetails;

public class Test {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
		user.setJoinedDate(new Date());
		
		Address addr1 = new Address();
		addr1.setStreet("Main ST");
		addr1.setCity("NYC");
		addr1.setState("NY");
		addr1.setZipcode("11111");
		
		Address addr2 = new Address();
		addr2.setStreet("Main ST");
		addr2.setCity("Miami");
		addr2.setState("FL");
		addr2.setZipcode("22222");
		
		user.getListOfaddrs().add(addr1);
		user.getListOfaddrs().add(addr2);
		
		
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		//Retrieving Objects Using session.get()
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		//System.out.println(user.getUserName());
		session.close();
		System.out.println(user.getListOfaddrs().size());
	


	}

}
