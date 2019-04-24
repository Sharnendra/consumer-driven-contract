package com.fsc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fsc.model.Car;
import com.fsc.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping(Constants.MARKETPLACE_GET_URL)
	public Car internalFindProductById(@PathVariable("id") Long id) {
		return productService.findProductById(id, true);
	}

	@GetMapping(Constants.ECOMMERCE_GET_URL)
	public Car externalFindProductById(@PathVariable("id") Long id) {
		return productService.findProductById(id, false);
	}
}
