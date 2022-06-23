package br.com.rafael.controller;

import br.com.rafael.controller.dto.OutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.rafael.controller.dto.InputDTO;
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
