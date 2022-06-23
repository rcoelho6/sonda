package br.com.rafael.controller.dto;

import br.com.rafael.domain.DirectionEnum;
import br.com.rafael.domain.Probe;

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
