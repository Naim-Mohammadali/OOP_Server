package com.taskmanager.dao;

import com.taskmanager.model.User;
import jakarta.persistence.EntityManager;

public class UserDao {
    private final EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public User findById(Long id) {
        return em.find(User.class, id);
    }
}
