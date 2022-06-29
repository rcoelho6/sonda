package br.com.rafael.controllers;

import br.com.rafael.controllers.dtos.OutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rafael.controllers.dtos.InputDTO;
import br.com.rafael.usercases.ProbeUserCase;

@Controller
@RequestMapping("/planet-with-probes")
public class PlanetAndProbeController {
	@Autowired
	private ProbeUserCase probeUserCase;

	@PostMapping
    public ResponseEntity<OutputDto> register(@RequestBody InputDTO inputDto) {
		var planet = probeUserCase.landProbes(inputDto.toPlanetDomain());
		return ResponseEntity.ok(OutputDto.fromDomain(planet));
    }
}
