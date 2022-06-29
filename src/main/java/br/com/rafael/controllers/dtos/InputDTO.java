package br.com.rafael.controllers.dtos;

import br.com.rafael.domains.Planet;
import br.com.rafael.domains.Probe;

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
