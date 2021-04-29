package project.day19Logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log4j2Logging {

    private static final Logger LOGGER = LogManager.getLogger(Log4j2Logging.class.getName());

    public static void main(String[] args){

        LOGGER.fatal("Сообщение с уровнем fatal");
        LOGGER.error("Сообщение с уровнем error");
        LOGGER.warn("Сообщение с уровнем warn");
        LOGGER.info("Сообщение с уровнем info");
        LOGGER.debug("Сообщение с уровнем debug");
        LOGGER.trace("Сообщение с уровнем trace");
    }
}
