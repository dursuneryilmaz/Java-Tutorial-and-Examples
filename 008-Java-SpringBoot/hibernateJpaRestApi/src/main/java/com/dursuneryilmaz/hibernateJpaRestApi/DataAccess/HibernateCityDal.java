package com.dursuneryilmaz.hibernateJpaRestApi.DataAccess;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.dursuneryilmaz.hibernateJpaRestApi.Entities.City;

// Hibernate configuration handled by JPA(Java Persistance API)
public class HibernateCityDal implements ICityDal {
	private EntityManager entityManager;
	
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional // Aspect Oriented Programming, Session's Unit of Work handling
	public List<City> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<City> cities = session.createQuery("from City",City.class).getResultList();
		return cities;
	}

	@Override
	public void add(City city) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(City city) {
		// TODO Auto-generated method stub

	}

}
