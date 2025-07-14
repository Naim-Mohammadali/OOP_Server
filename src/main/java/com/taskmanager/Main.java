package com.taskmanager;

import com.taskmanager.dao.UserDao;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;
import com.taskmanager.util.DatabaseManager;
import jakarta.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        // Get EntityManager
        EntityManager em = DatabaseManager.getInstance().getEntityManager();

        // Create DAO
        UserDao userDao = new UserDao(em);

        // Create user
        User user = new User("Ali");

        // Create tasks
        Task t1 = new Task("Complete mini project");
        Task t2 = new Task("Review DAO pattern");

        // Link tasks to user
        user.addTask(t1);
        user.addTask(t2);

        // Save user (will cascade and save tasks)
        userDao.save(user);

        // Retrieve user by ID
        User found = userDao.findById(user.getId());
        System.out.println("Found user: " + found.getName());
        for (Task task : found.getTasks()) {
            System.out.println("  Task: " + task.getDescription());
        }

        // Clean up
        em.close();
        DatabaseManager.getInstance().close();
    }
}
