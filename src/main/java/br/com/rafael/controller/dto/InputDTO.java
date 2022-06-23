package br.com.rafael.controller.dto;

import br.com.rafael.domain.Planet;
import br.com.rafael.domain.Probe;

import java.util.List;
import java.util.stream.Collectors;

public class InputDTO {
	private int width; 
	private int height;
	private List<ProbeDto> probes;

	public Planet toPlanetDomain() {
		var planet = getPlanet();
		planet.setProbes(getProbes());
		return planet;
	}

	private List<Probe> getProbes() {
		return probes.stream().map( it -> {
			var domain = it.toDomain();
			return domain;
		}).collect(Collectors.toList());
	}

	private Planet getPlanet() {
		var planet = new Planet();
		planet.setWidth(width);
		planet.setWidth(height);
		return planet;
	}
}
