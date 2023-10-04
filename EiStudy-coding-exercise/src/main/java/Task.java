package main.java;

import java.time.LocalDate;

public class Task {
    private String description;
    private boolean completed;
    private LocalDate dueDate;

    public Task(String description) {
        this.description = description;
        this.completed = false;
        this.dueDate = null;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        this.completed = true;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
