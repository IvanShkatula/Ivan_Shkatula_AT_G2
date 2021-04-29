package project.day19Logging;


import org.apache.log4j.Logger;

public class L4JLogging {
    private static final Logger LOGGER = Logger.getLogger(L4JLogging.class.getName());

    public static void main(String[] args){

        LOGGER.fatal("Сообщение с уровнем fatal");
        LOGGER.error("Сообщение с уровнем error");
        LOGGER.warn("Сообщение с уровнем warn");
        LOGGER.info("Сообщение с уровнем info");
        LOGGER.debug("Сообщение с уровнем debug");
        LOGGER.trace("Сообщение с уровнем trace");
    }
}
