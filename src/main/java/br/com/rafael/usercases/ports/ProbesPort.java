package br.com.rafael.usercases.ports;

import java.util.Optional;

import br.com.rafael.domain.Probe;

public interface ProbesPort {

	void save(Probe probe);

	Optional<Probe> findById(int id);

}
