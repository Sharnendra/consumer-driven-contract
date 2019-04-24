package com.fsc.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fsc.model.Car;

@Service
public class ProductService {

	private final Map<Long, Car> personMap;

	public ProductService() {
		personMap = new HashMap<>();
		personMap.put(1L, new Car(1L, 1000L, "ECOSPORT", "Petrol Car"));
		personMap.put(2L, new Car(2L, 1000L, "S-MAX", "Disel Car"));
		personMap.put(3L, new Car(3L, 300L, "FORD GT", "Electric Car"));
	}

	public Car findProductById(Long id, boolean isInternallCall) {
		Car car = personMap.get(id);
		car.setStock(isInternallCall ? car.getStock() : 0l);
		return car;
	}
}
