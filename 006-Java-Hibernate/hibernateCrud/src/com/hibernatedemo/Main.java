package com.hibernatedemo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/* HQL--> Hibernate Query Language
 *
 * */
public class Main {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(City.class)
				.buildSessionFactory();

		// Session works on unit of work principle
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			
	    // CREATE
		/*
			City city = new City();
			city.setName("Düzce X");
			city.setCountryCode("TUR");
			city.setDistrict("Karadeniz");
			city.setPopulation(100000);
			session.save(city);
		*/
		//READ
		/*
		 	// select c.countryCode from City c GROUP BY c.countryCode
		 	// from City c where c.name LIKE '%kar%'
		 	// from City c where c.countryCode='TUR' AND c.district='Ankara'
			List<City> cities = session.createQuery("from City").getResultList();
			System.out.println("List of Cities:");
			for (City city : cities) {
				System.out.println(city.getName());
			}
		*/
			
		//UPDATE
		/*
			session.beginTransaction();
			City city = session.get(City.class, 4083);
			city.setPopulation(110000);
			session.save(city);
		*/
			
			// DELETE
			City city = session.get(City.class, 4081);
			session.delete(city);
			session.getTransaction().commit();
		} finally {
			factory.close();
		}
	}
}
