package com.solvd.connectionpool;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Connection implements Runnable {

    private String connectionId;
    private boolean open;
    private static final Logger logger = LogManager.getLogger(Connection.class);

    public Connection(String connectionId) {
        this.connectionId = connectionId;
        open = true;
    }

    public String getConnectionId() {
        return connectionId;
    }

    public boolean isOpen() {
        return open;
    }

    public void executeQuery(String query) {
        if (isOpen()) {
            // Query Database
            logger.info("Executing query '{}' on connection {}", query, connectionId);
            // Generated Result
            Random random = new Random();
            boolean result = random.nextBoolean();
            logger.info("Query result: {}", result);
        } else {
            logger.info("Connection {} is closed. Cannot execute query.", connectionId);
        }
    }

    public void close() {
        open = false;
    }

    @Override
    public void run() {
        logger.info("Thread executing connection {}", connectionId);

        executeQuery("SELECT * FROM table");
    }
}
