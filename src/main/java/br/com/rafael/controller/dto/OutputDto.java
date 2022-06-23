package br.com.rafael.controller.dto;

import br.com.rafael.domain.Planet;

import java.util.List;
import java.util.stream.Collectors;

public class OutputDto {
	private int planetId;
	private int width; 
	private int height;
	private List<ProbeDto> probes;

	public static OutputDto fromDomain(Planet planet) {
		var dto = new OutputDto();
		dto.planetId = planet.getId();
		dto.width = planet.getWidth();
		dto.height = planet.getHeight();
		dto.probes = planet.getProbes().stream().map(probe -> ProbeDto.fromDomain(probe)).collect(Collectors.toList());
		return dto;
	}
}
