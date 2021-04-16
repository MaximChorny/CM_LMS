package com.max.CM_LMS.domain.Presentation;

import java.util.Optional;
import java.util.Scanner;

public class StarView {

    public void run() {
        String commandStr;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            commandStr = scanner.next();
            Optional<Command> command = Optional.ofNullable(Command.findMatch(commandStr));
            if(!command.isPresent()){
                System.exit(1);
            }
            if(commandStr.equalsIgnoreCase("help")){
                System.out.println("Мне тоже нужна помощь");
            }
        }
    }
}
