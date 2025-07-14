package com.taskmanager.dao;

import com.taskmanager.model.Task;
import jakarta.persistence.EntityManager;

public class TaskDao {
    private final EntityManager em;

    public TaskDao(EntityManager em) {
        this.em = em;
    }

    public void save(Task task) {
        em.getTransaction().begin();
        em.persist(task);
        em.getTransaction().commit();
    }

    public Task findById(Long id) {
        return em.find(Task.class, id);
    }
}
