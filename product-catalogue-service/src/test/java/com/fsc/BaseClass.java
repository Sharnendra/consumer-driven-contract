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

		Mockito.when(personService.findPersonById(1L)).thenReturn(new Car(1L, "foo", "bee"));
	}

}
