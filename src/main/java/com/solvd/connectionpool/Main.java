package com.solvd.connectionpool;

import com.solvd.connectionpool.ConnectionPool;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    private static int nextConnectionId = 1;

    public static synchronized int getNextConnectionId() {
        return nextConnectionId++;
    }

    public static void main(String[] args) {
        final int maxConnections = 4;
        final int totalThreads = 8;
        int waitingThreads = totalThreads - maxConnections;

        ConnectionPool connectionPool = ConnectionPool.getInstance(maxConnections);

        for (int i = 0; i < maxConnections; i++) {
            connectionPool.getConnection();
        }

        for (int i = 0; i < waitingThreads; i++) {
            logger.info("Thread " + i + " is waiting for a connection.");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = maxConnections; i < totalThreads; i++) {
            connectionPool.getConnection();
        }
    }
}