package br.com.rafael.controllers.dtos;

import br.com.rafael.domains.enums.DirectionEnum;
import br.com.rafael.domains.Probe;

public class ProbeDto {
	private int x; 
	private int y;
	private char direction;
	private String commands;

	public static ProbeDto fromDomain(Probe probe) {
		var dto = new ProbeDto();
		dto.x = probe.getX();
		dto.y = probe.getY();
		dto.commands = probe.getCommands().toString();
		dto.direction = probe.getDirection().getValue();
		return dto;
	}

	public Probe toDomain() {
		Probe probe = new Probe();
		probe.setX(probe.getX());
		probe.setY(probe.getY());
		probe.setCommands(commands.toCharArray());
		probe.setDirection(DirectionEnum.valueOf(direction));
		return probe;
	}
}
