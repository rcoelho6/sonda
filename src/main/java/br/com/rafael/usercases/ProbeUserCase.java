package br.com.rafael.usercases;

import br.com.elo7.sonda.candidato.domain.*;
import br.com.rafael.domain.CommandEnum;
import br.com.rafael.domain.DirectionEnum;
import br.com.rafael.domain.Planet;
import br.com.rafael.domain.Probe;
import org.springframework.stereotype.Service;

import com.google.common.annotations.VisibleForTesting;
import br.com.rafael.usercases.ports.PlanetsPort;
import br.com.rafael.usercases.ports.ProbesPort;

@Service
public class ProbeUserCase {

	private PlanetsPort planetsPort;
	private ProbesPort probesPort;

	public ProbeUserCase(PlanetsPort planetsPort, ProbesPort probesPort) {
		this.planetsPort = planetsPort;
		this.probesPort = probesPort;
	}

	public Planet landProbes(Planet planet) {
		var id = planetsPort.save(planet);
		planet.setId(id);
		convertAndMoveProbes(planet);
		planet.getProbes().forEach(probe -> {
			probesPort.save(probe);
		});
		return planet;
	}

	private void convertAndMoveProbes(Planet planet) {
		planet.getProbes().forEach(probe -> moveProbeWithAllCommands(probe));
	}

	private void moveProbeWithAllCommands(Probe probe) {
		for (var command : probe.getCommands()) {
			applyCommandToProbe(probe, command);
		}
	}

	@VisibleForTesting
	void applyCommandToProbe(Probe probeModel, char command) {
		switch (CommandEnum.valueOf(command)) {
			case RIGHT:
				turnProbeRight(probeModel);
				break;
			case LEFT:
				turnProbeLeft(probeModel);
				break;
			case MOVE:
				moveProbeForward(probeModel);
				break;
		}
	}

	private void moveProbeForward(Probe probe) {
		int newX = probe.getX();
		int newY = probe.getY();
		switch (probe.getDirection()) {
			case NORTH:
				newY++;
				break;
			case WEST:
				newX--;
				break;
			case SOUTH:
				newY--;
				break;
			case EAST:
				newX++;
				break;
		}
		probe.setX(newX);
		probe.setY(newY);
	}

	private void turnProbeLeft(Probe probe) {
		var newDirection = DirectionEnum.NORTH;
		switch (probe.getDirection()) {
			case NORTH:
				newDirection = DirectionEnum.WEST;
				break;
			case WEST:
				newDirection = DirectionEnum.SOUTH;
				break;
			case SOUTH:
				newDirection = DirectionEnum.EAST;
				break;
			case EAST:
				newDirection = DirectionEnum.NORTH;
				break;
		}
		probe.setDirection(newDirection);
	}
	
	private void turnProbeRight(Probe probe) {
		var newDirection = DirectionEnum.NORTH;
		switch (probe.getDirection()) {
			case NORTH:
				newDirection = DirectionEnum.EAST;
				break;
			case EAST:
				newDirection = DirectionEnum.SOUTH;
				break;
			case SOUTH:
				newDirection = DirectionEnum.WEST;
				break;
			case WEST:
				newDirection = DirectionEnum.NORTH;
				break;
		}
		System.out.println(newDirection);
		probe.setDirection(newDirection);
	}
}
