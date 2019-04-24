package com.fsc;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.fsc.CatalogueServiceApplication;
import com.fsc.api.ProductRestController;
import com.fsc.model.Car;
import com.fsc.service.ProductService;

import io.restassured.module.mockmvc.RestAssuredMockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CatalogueServiceApplication.class)
public abstract class BaseClass {

	@Autowired
	ProductRestController productRestController;

	@MockBean
	ProductService personService;

	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(productRestController);
		// Internal Call
		Mockito.when(personService.findProductById(1L, true)).thenReturn(new Car(1L, 1000L, "ECOSPORT", "Petrol Car"));
		Mockito.when(personService.findProductById(2L, true)).thenReturn(new Car(2L, 1000L, "S-MAX", "Disel Car"));
		Mockito.when(personService.findProductById(3L, true)).thenReturn(new Car(3L, 3000L, "FORD GT", "Electric Car"));
		// External Call
		Mockito.when(personService.findProductById(1L, false)).thenReturn(new Car(1L, 0L, "ECOSPORT", "Petrol Car"));
		Mockito.when(personService.findProductById(2L, false)).thenReturn(new Car(2L, 0L, "S-MAX", "Disel Car"));
		Mockito.when(personService.findProductById(3L, false)).thenReturn(new Car(3L, 0L, "FORD GT", "Electric Car"));
	}
}
