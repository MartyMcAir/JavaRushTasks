package com.javarush.task.task34.task3409;


import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Настраиваем логгер
*/
public class Solution {
    private static final Logger logger = LoggerFactory.getLogger(Solution.class);

    public static void main(String args[]) throws IOException {
        // ERROR No output stream or file set for the appender named [null].
//        org.apache.log4j.Logger.getRootLogger().addAppender(new ConsoleAppender());
//        org.apache.log4j.Logger.getRootLogger().addAppender(new FileAppender());
        // No appenders could be found for logger

        logger.debug("Start Main Method");

        // путь к логгируемому файлу
        String logProperties = "4.JavaCollections/src/" +
                Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/log4j.properties";
        Path path = Paths.get(logProperties).toAbsolutePath();
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
            PropertyConfigurator.configure(properties);
        }

        logger.error("Hello error");
        logger.warn("Warn warn!");
        logger.info("Information");
    }
}
