package com.max.CM_LMS;

import com.max.CM_LMS.domain.Presentation.StarView;
import com.max.CM_LMS.domain.dao.*;
import com.max.CM_LMS.domain.dao.factory.DaoAbstractFactory;
import org.apache.commons.cli.*;

public class AppRunner {

    public static void main(String[] args) {
        String dbType = checkArgs(args);
        DaoAbstractFactory factory = new DaoAbstractFactory();
        FeedDao feedDao = factory.createFeedDao(dbType);
        GroupDao groupDao = factory.createGroupDao(dbType);
        HomeTaskDao homeTaskDao = factory.createHomeTask(dbType);
        HomeWorkDao homeWorkDao = factory.createHomeWork(dbType);
        LessonDao lessonDao = factory.createLessonDao(dbType);
        PostDao postDao = factory.createPostDao(dbType);
        UserDao userDao = factory.createUserDao(dbType);

        StarView first = new StarView();
        first.run();
    }

    private static String checkArgs(String[] args) {
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
            return str;
        } else {
            return "InMemory";
        }
    }


}
