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
		personMap.put(1L, new Car(1L, "Richard", "Gere"));
		personMap.put(2L, new Car(2L, "Emma", "Choplin"));
		personMap.put(3L, new Car(3L, "Anna", "Carolina"));
	}

	public Car findPersonById(Long id) {
		return personMap.get(id);
	}
}
