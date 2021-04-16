package com.max.CM_LMS.domain.Presentation;

import java.util.Optional;

public enum Command {

    HELP("help", "helps user");


    private String value;
    private String description;

    Command(String value, String description) {
        this.value = value;
        this.description = description;
    }

    static Command findMatch(String value) {
        if (value.equalsIgnoreCase("help")) {
            return HELP;
        }
        return null;
    }

    public static Optional<Command> getCommand(String commandString) {
        Command[] commands = Command.values();
        Optional<Command> result = Optional.empty();
        for (Command command : commands) {
            if (command.value.equals(commandString)) {
                result = Optional.of(command);
            }
        }
        return result;
    }
}
