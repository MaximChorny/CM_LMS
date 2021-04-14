package com.max.CM_LMS;

import com.max.CM_LMS.domain.Presentation.StarView;
import org.apache.commons.cli.*;

import java.util.Date;

public class AppRunner {

    public static void main(String[] args) {
        checkArgs(args);
        StarView first = new StarView();
        first.run();
    }

    private static void checkArgs(String[] args) {
        Options options = new Options();
        Option option1 = Option.builder()
                .argName("db")      // название
                .longOpt("dbType")   // длинное название
                .hasArg(true)        //Указывает, что для параметра потребуется аргумент
                .desc("call abstract fabric")
                .required(false)      //Устанавливает, является ли параметр обязательным
                .build();
        options.addOption(option1);

        CommandLine cmd = null;
        try {
            cmd = new DefaultParser().parse(options, args);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (cmd.hasOption("dbType")) {
            String str = cmd.getOptionValue("dbType");
            if (str.equals("InMemory")) {
                System.out.println("you choose InMemory");
            } else {
                System.out.println("you choose jdbc");
            }
        }
    }


}
