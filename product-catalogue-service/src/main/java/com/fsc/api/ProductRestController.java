package com.fsc.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fsc.model.Car;
import com.fsc.service.ProductService;

@RestController
public class ProductRestController {

	private final ProductService productService;

	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/person/{id}")
	public Car findPersonById(@PathVariable("id") Long id) {
		return productService.findPersonById(id);
	}
}
