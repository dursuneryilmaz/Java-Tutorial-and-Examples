package com.dursuneryilmaz.hibernateJpaRestApi.Business;

import java.util.List;
import com.dursuneryilmaz.hibernateJpaRestApi.Entities.City;

public interface ICityService {
	List<City> getAll();

	void add(City city);

	void update(City city);

	void delete(City city);
}
