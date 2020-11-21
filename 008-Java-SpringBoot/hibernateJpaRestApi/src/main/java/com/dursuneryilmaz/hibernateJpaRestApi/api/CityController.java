package com.dursuneryilmaz.hibernateJpaRestApi.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dursuneryilmaz.hibernateJpaRestApi.Business.ICityService;
import com.dursuneryilmaz.hibernateJpaRestApi.Entities.City;

@RestController
@RequestMapping("/api")
public class CityController {
	private ICityService cityService;

	@Autowired
	public CityController(ICityService cityService) {
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")
	public List<City> getAll() {
		return cityService.getAll();
	}
}
