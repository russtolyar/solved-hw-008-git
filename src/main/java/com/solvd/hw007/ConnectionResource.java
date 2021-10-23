package com.solvd.hw007;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionResource implements AutoCloseable {

    private static final Logger LOGGER = LogManager.getLogger(ConnectionResource.class);

    public void connect() {
        LOGGER.info("Connection was established");
    }

    @Override
    public void close() {

        LOGGER.info("Connection was closed");
    }
}
