package main.java;

import java.time.LocalDate;

public class TaskBuilder {
    private String description;
    private LocalDate dueDate;

    public TaskBuilder(String description) {
        this.description = description;
    }

    public TaskBuilder withDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Task build() {
        Task task = new Task(description);
        if (dueDate != null) {
            task.setDueDate(dueDate);
        }
        return task;
    }
}
