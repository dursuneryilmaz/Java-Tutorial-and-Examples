package com.dursuneryilmaz.hibernateJpaRestApi.Business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dursuneryilmaz.hibernateJpaRestApi.DataAccess.ICityDal;
import com.dursuneryilmaz.hibernateJpaRestApi.Entities.City;

@Service
public class CityManager implements ICityService {
	private ICityDal cityDal;

	@Autowired
	public CityManager(ICityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> getAll() {
		// business logic
		return this.cityDal.getAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		// business logic
		this.cityDal.add(city);

	}

	@Override
	@Transactional
	public void update(City city) {
		// business logic
		this.cityDal.update(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		// business logic
		this.cityDal.delete(city);
	}

	@Override
	public City getById(int id) {
		// business logic
		return this.cityDal.getById(id);
	}

}
