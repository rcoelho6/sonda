package br.com.rafael.persistences.models;

import br.com.rafael.domains.enums.DirectionEnum;

public class ProbeModel {
	private int id;
	private int x;
	private int y;
	private DirectionEnum direction;
	private PlanetModel planetModel;
}
