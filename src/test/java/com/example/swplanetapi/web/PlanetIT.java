package com.example.swplanetapi.web;

import static com.example.swplanetapi.common.PlanetConstants.PLANET;
import static com.example.swplanetapi.common.PlanetConstants.TATOOINE;
import static com.example.swplanetapi.common.PlanetConstants.YAVINIV;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import com.example.swplanetapi.domain.Planet;

@ActiveProfiles("it")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = { "/import_planets.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = { "/remove_planets.sql" }, executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class PlanetIT {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void createPlanet_WithValidData_ReturnsCreated() {

		ResponseEntity<Planet> sut = restTemplate.postForEntity("/planets", PLANET, Planet.class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(sut.getBody().getId()).isNotNull();
		assertThat(sut.getBody().getName()).isEqualTo(PLANET.getName());
		assertThat(sut.getBody().getClimate()).isEqualTo(PLANET.getClimate());
		assertThat(sut.getBody().getTerrain()).isEqualTo(PLANET.getTerrain());
	}

	@Test
	public void createPlanet_WithInvalidData_ReturnsBadRequest() {

		Planet emptyPlanet = new Planet();
		Planet invalidPlanet = new Planet("", "", "");

		ResponseEntity<Planet> sut = restTemplate.postForEntity("/planets", emptyPlanet, Planet.class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
		assertThat(sut.getBody()).isNull();

		sut = restTemplate.postForEntity("/planets", invalidPlanet, Planet.class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.UNPROCESSABLE_ENTITY);
		assertThat(sut.getBody()).isNull();
	}

	@Test
	public void getPlanet_ByExistingId_ReturnsPlanet() {

		ResponseEntity<Planet> sut = restTemplate.getForEntity("/planets/1", Planet.class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(sut.getBody()).isEqualTo(TATOOINE);
	}

	@Test
	public void getPlanet_ByUnexistingId_ReturnsNotFound() {

		ResponseEntity<Planet> sut = restTemplate.getForEntity("/planets/99", Planet.class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(sut.getBody()).isNull();
	}

	@Test
	public void getPlanet_ByExistingName_ReturnsPlanet() {

		ResponseEntity<Planet> sut = restTemplate.getForEntity("/planets/name/" + YAVINIV.getName(), Planet.class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(sut.getBody()).isEqualTo(YAVINIV);
	}

	@Test
	public void getPlanet_ByUnexistingName_ReturnsNotFound() {

		final String name = "Unexisting name";
		ResponseEntity<Planet> sut = restTemplate.getForEntity("/planets/name/" + name, Planet.class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
		assertThat(sut.getBody()).isNull();

	}

	@Test
	public void listPlanets_ReturnAllPlanets() {

		ResponseEntity<Planet[]> sut = restTemplate.getForEntity("/planets", Planet[].class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(sut.getBody()).hasSize(3);
		assertThat(sut.getBody()[0]).isEqualTo(TATOOINE);
	}

	@Test
	public void listPlanets_ByClimate_ReturnPlanets() {

		ResponseEntity<Planet[]> sut = restTemplate.getForEntity("/planets?climate=" + TATOOINE.getClimate(),
				Planet[].class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(sut.getBody()).hasSize(1);
		assertThat(sut.getBody()[0]).isEqualTo(TATOOINE);
	}

	@Test
	public void listPlanets_ByTerrain_ReturnPlanets() {

		ResponseEntity<Planet[]> sut = restTemplate.getForEntity("/planets?terrain=" + YAVINIV.getTerrain(),
				Planet[].class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(sut.getBody()).hasSize(1);
		assertThat(sut.getBody()[0]).isEqualTo(YAVINIV);

	}

	@Test
	public void listPlanets_ReturnNoPlanets() {

		final String terrain = "UnexistingTerrain";
		ResponseEntity<Planet[]> sut = restTemplate.getForEntity("/planets?terrain=" + terrain, Planet[].class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(sut.getBody()).hasSize(0);
	}

	@Test
	public void removePlanet_WithExistingId_ReturnsNoContent() {

		ResponseEntity<Void> sut = restTemplate.exchange("/planets/" + TATOOINE.getId(), HttpMethod.DELETE, null,
				Void.class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	}

	@Test
	public void removePlanet_WithUnexistingId_ReturnsNotFound() {

		ResponseEntity<Void> sut = restTemplate.exchange("/planets/99", HttpMethod.DELETE, null, Void.class);

		assertThat(sut.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}
}
































