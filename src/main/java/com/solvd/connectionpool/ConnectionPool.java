package com.solvd.connectionpool;

import com.solvd.connectionpool.Connection;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConnectionPool {
    private static ConnectionPool instance;
    private final ExecutorService executorService;
    private final int maxConnections;
    private int connectionCounter = 1;

    private ConnectionPool(int maxConnections) {
        this.maxConnections = maxConnections;
        this.executorService = Executors.newFixedThreadPool(maxConnections);
    }

    public static synchronized ConnectionPool getInstance(int maxConnections) {
        if (instance == null) {
            instance = new ConnectionPool(maxConnections);
        }
        return instance;
    }

    public void getConnection() {
        executorService.execute(new Connection(getNextConnectionId()));
    }

    private int getNextConnectionId() {
        synchronized (this) {
            return connectionCounter++;
        }
    }

    public int getMaxConnections() {
        return maxConnections;
    }
}