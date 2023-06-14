package com.example.swplanetapi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.EqualsBuilder;

import com.example.swplanetapi.jacoco.ExcludeFromJacocoGeneratedReport;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planets")
public class Planet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	@Column(nullable = false, unique = true)
	private String name;

	@NotEmpty
	@Column(nullable = false)
	private String climate;

	@NotEmpty
	@Column(nullable = false)
	private String terrain;

	public Planet(String name, String climate, String terrain) {
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
	}

	public Planet(String climate, String terrain) {
		this.climate = climate;
		this.terrain = terrain;
	}
	
	public Planet(String terrain) {
		this.terrain = terrain;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(obj, this);
	}
	
	@ExcludeFromJacocoGeneratedReport
	@Override
	public String toString() {
		return "Planet [climate=" + climate + ", id=" + id + ", name=" + name + ", terrain=" + terrain + "]";
	}
}
