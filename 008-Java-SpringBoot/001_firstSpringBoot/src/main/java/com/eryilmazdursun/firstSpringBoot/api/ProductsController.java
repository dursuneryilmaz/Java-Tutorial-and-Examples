package com.eryilmazdursun.firstSpringBoot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {
	@GetMapping("/")
	public String get() {
		return "Laptop";
	}
	
	@GetMapping("/product")
	public String getProduct() {
		return "Laptop Test";
	}
}
