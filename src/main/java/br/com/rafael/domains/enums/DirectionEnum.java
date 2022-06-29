package br.com.rafael.domains.enums;

public enum DirectionEnum {
    NORTH('N'),
	WEST('W'),
	EAST('E'),
	SOUTH('S');

	private final char direction;

	DirectionEnum(char direction) {
		this.direction = direction;
	}

	public static DirectionEnum valueOf(char direction) {
		for (var directionEnum: DirectionEnum.values()) {
			if (directionEnum.direction == direction) {
				return directionEnum;
			}
		}
		throw new RuntimeException(String.format("Value %s not found on DirectionEnum", direction));
	}

	public char getValue() {
		return direction;
	}
}
