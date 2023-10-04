package main.java;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TodoListApp {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Options:");
                System.out.println("1. Add Task");
                System.out.println("2. Mark Task as Completed");
                System.out.println("3. Delete Task");
                System.out.println("4. View Tasks");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter task description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter due date (yyyy-MM-dd): ");
                        String dueDateString = scanner.nextLine();

                        try {
                            LocalDate dueDate = LocalDate.parse(dueDateString);
                            Task task = new TaskBuilder(description)
                                    .withDueDate(dueDate)
                                    .build();

                            taskManager.addTask(task);
                            System.out.println("Task added successfully.");
                        } catch (DateTimeParseException ex) {
                            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter the task description to mark as completed: ");
                        String taskDescription = scanner.nextLine();
                        taskManager.markTaskAsCompleted(taskDescription);
                        System.out.println("Task marked as completed.");
                        break;
                    case 3:
                        System.out.print("Enter the task description to delete: ");
                        String taskToDelete = scanner.nextLine();
                        taskManager.deleteTask(taskToDelete);
                        System.out.println("Task deleted.");
                        break;
                    case 4:
                        System.out.println("View Options:");
                        System.out.println("1. Show all");
                        System.out.println("2. Show completed");
                        System.out.println("3. Show pending");
                        System.out.print("Enter your choice: ");

                        int viewChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        switch (viewChoice) {
                            case 1:
                                List<Task> allTasks = taskManager.getAllTasks();
                                if (allTasks.isEmpty()) {
                                    System.out.println("No tasks found.");
                                } else {
                                    System.out.println("All Tasks:");
                                    for (Task t : allTasks) {
                                        System.out.println(t.getDescription() + " - " +
                                                (t.isCompleted() ? "Completed" : "Pending") +
                                                (t.getDueDate() != null ? ". Due " + t.getDueDate() : ""));
                                    }
                                }
                                break;
                            case 2:
                                List<Task> completedTasks = taskManager.filterTasks(true);
                                if (completedTasks.isEmpty()) {
                                    System.out.println("No completed tasks found.");
                                } else {
                                    System.out.println("Completed Tasks:");
                                    for (Task t : completedTasks) {
                                        System.out.println(t.getDescription() + " - Completed" +
                                                (t.getDueDate() != null ? ". Due " + t.getDueDate() : ""));
                                    }
                                }
                                break;
                            case 3:
                                List<Task> pendingTasks = taskManager.filterTasks(false);
                                if (pendingTasks.isEmpty()) {
                                    System.out.println("No pending tasks found.");
                                } else {
                                    System.out.println("Pending Tasks:");
                                    for (Task t : pendingTasks) {
                                        System.out.println(t.getDescription() + " - Pending" +
                                                (t.getDueDate() != null ? ". Due " + t.getDueDate() : ""));
                                    }
                                }
                                break;
                            default:
                                System.out.println("Invalid choice for viewing tasks.");
                                break;
                        }
                        break;
                    case 5:
                        System.out.println("Exiting the application.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}
