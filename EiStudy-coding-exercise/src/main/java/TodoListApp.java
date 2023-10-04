package main.java;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoListApp{

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Options:");
                System.out.println("1. Add Task");
                System.out.println("2. Mark tasks are completed");
                System.out.println("3. Delete Tasks");
                System.out.println("4. View Tasks");
                System.out.println("5. Exit");
                System.out.println("Enter your choice");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter task description");
                        String description = scanner.nextLine();
                        System.out.println("Enter due date (yyyy-mm-dd): ");
                        String dueDateString = scanner.nextLine();
                        try {
                            //create date
                            LocalDate dueDate = LocalDate.parse(dueDateString);
                            //addTask(description, dueDate);    -- to add the task, I created a method
                            System.out.println("Task added successfully");
                        } catch (DateTimeParseException ex) {
                            // To catch date format error
                            System.out.println("Invalid date format.");
                        }
                        break;
                    case 2:
                        System.out.println("Enter task description to mark as completed");
                        String taskDescription = scanner.nextLine();
                       
                        //markCompleted(taskDescription);    -- to mark task as completed, I created a method
                        System.out.println("Marked as completed");
                        break;
                    case 3:
                        System.out.println("Enter task description to delete");
                        String taskToDelete = scanner.nextLine();
                       
                         //deleteTask(taskToDelete);    -- to mark task as completed, I created a method
                        System.out.println("Deleted");
                    break;
                    case 4:
                    System.out.println("View Options:");
                    System.out.println("1. Show all");
                    System.out.println("2. Show completed");
                    System.out.println("3. Show pending");
                    System.out.println("Enter your choice: ");
                    int viewChoice = scanner.nextInt();
                    scanner.nextLine();
                    //.....MAIN CONTENT.....
                
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            } catch (InputMismatchException e) {
                // To handle input if mismatching occurs....
                System.out.println("Invalid Input");
                scanner.nextLine();
            }
        }
    }
}