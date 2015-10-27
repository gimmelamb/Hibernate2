package com.olivia.mint;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.olivia.mint.model.Address;
import com.olivia.mint.model.FourWheeler;
import com.olivia.mint.model.TwoWheeler;
import com.olivia.mint.model.UserDetails;
import com.olivia.mint.model.Vehicle;

public class Test {

	public static void main(String[] args) {
		//UserDetails user = new UserDetails();
		//user.setUserId(1);
		//user.setUserName("First User");
		//user.setJoinedDate(new Date());
		
		/*Address addr1 = new Address();
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
		user.getListOfaddrs().add(addr2);*/
		
		Vehicle v = new Vehicle();
		v.setMake("BMW");
		//user.getVehicles().add(v);
		Vehicle v2 = new Vehicle();
		v2.setMake("BENZ");
		//user.getVehicles().add(v2);
		
		TwoWheeler bike = new TwoWheeler();
		bike.setMake("Giant");
		bike.setSteeringHandle("Bike steering handle");
		
		FourWheeler car = new FourWheeler();
		car.setMake("Ford");
		car.setSteeringWheel("Ford steering wheel");
		
		
		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//session.save(user);
		session.save(v);
		session.save(v2);
		session.save(bike);
		session.save(car);
		session.getTransaction().commit();
		session.close();
		
/*		//Retrieving Objects Using session.get()
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails) session.get(UserDetails.class, 1);
		//System.out.println(user.getUserName());
		session.close();
		//System.out.println(user.getListOfaddrs().size());
*/	


	}

}
