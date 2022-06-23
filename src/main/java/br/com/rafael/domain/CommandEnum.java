package br.com.rafael.domain;


public enum CommandEnum {
	MOVE('M'),
    LEFT('L'),
	RIGHT('R');

	private final char command;

	CommandEnum(char command) {
		this.command = command;
	}

	public static CommandEnum valueOf(char command) {
		for (var commandEnum: CommandEnum.values()) {
			if (commandEnum.command == command) {
				return commandEnum;
			}
		}
		throw new RuntimeException(String.format("Value %s not found on CommandEnum", command));
	}
}
