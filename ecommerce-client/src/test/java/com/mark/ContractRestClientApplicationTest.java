package com.mark;

import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.mark.model.Car;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContractRestClientApplicationTest {

	@Rule
	public StubRunnerRule stubRunnerRule = new StubRunnerRule()
			.downloadStub("com.example", "product-catalogue-service", "0.0.1-SNAPSHOT", "stubs").withPort(8100)
			.stubsMode(StubRunnerProperties.StubsMode.LOCAL);

	@Test
	public void get_person_from_service_contract() {
		// given:
		RestTemplate restTemplate = new RestTemplate();

		// when:
		ResponseEntity<Car> personResponseEntity = restTemplate.getForEntity("http://localhost:8100/externalget/1",
				Car.class);

		// then:
		BDDAssertions.then(personResponseEntity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(personResponseEntity.getBody().getId()).isEqualTo(1l);
		BDDAssertions.then(personResponseEntity.getBody().getStock()).isEqualTo(0L);
		BDDAssertions.then(personResponseEntity.getBody().getName()).isEqualTo("ECOSPORT");
		BDDAssertions.then(personResponseEntity.getBody().getType()).isEqualTo("Petrol Car");

	}
}
