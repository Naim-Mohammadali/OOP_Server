package com.taskmanager.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseManager {
    private static DatabaseManager instance;
    private final EntityManagerFactory emf;

    private DatabaseManager() {
        emf = Persistence.createEntityManagerFactory("task-manager-pu");
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
