package br.com.rafael.usercases;

import br.com.rafael.domains.enums.CommandEnum;
import br.com.rafael.domains.enums.DirectionEnum;
import br.com.rafael.domains.Planet;
import br.com.rafael.domains.Probe;
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
			var probeId = probesPort.save(probe);
			probe.setId(probeId);
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
	void applyCommandToProbe(Probe probe, char command) {
		switch (CommandEnum.valueOf(command)) {
			case RIGHT:
				probe.turnRight();
				break;
			case LEFT:
				probe.turnLeft();
				break;
			case MOVE:
				probe.move();
				break;
		}
	}
}
