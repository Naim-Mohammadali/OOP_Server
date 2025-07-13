package com.taskmanager.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();

    public User() {}

    public User(String name) {
        this.name = name;
    }

    public void addTask(Task task) {
        tasks.add(task);
        task.setUser(this);  // Set the reverse link
    }

    // Getters and setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Task> getTasks() { return tasks; }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}
