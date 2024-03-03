import java.util.ArrayList;
import java.util.Scanner;

public class TaskListApp {
    private static ArrayList<String> tasks = new ArrayList<>();
    private static ArrayList<String> completedTasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            int choice = displayTaskOptionsAndGetChoice();
            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    completeTask();
                    break;
                case 3:
                    viewCompletedTasks();
                    break;
                case 4:
                    viewPendingTasks();
                    break;
                case 5:
                    clearCompletedTasks();
                    break;
                case 6:
                    exitProgram();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int displayTaskOptionsAndGetChoice() {
        System.out.println("Task Manager");
        System.out.println("1. Add Task");
        System.out.println("2. Complete Task");
        System.out.println("3. View Completed Tasks");
        System.out.println("4. View Pending Tasks");
        System.out.println("5. Clear Completed Tasks");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine().trim());
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String task = scanner.nextLine().trim();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    private static void completeTask() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        listTasks();
        System.out.print("Enter the task number to complete: ");
        int taskNumber = Integer.parseInt(scanner.nextLine().trim());
        if (isValidTaskNumber(taskNumber)) {
            String completedTask = tasks.remove(taskNumber - 1);
            completedTasks.add(completedTask);
            System.out.println("Task '" + completedTask + "' completed and removed from the list.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void viewCompletedTasks() {
        System.out.println("Completed Tasks:");
        if (completedTasks.isEmpty()) {
            System.out.println("No tasks have been completed.");
            return;
        }
        for (int i = 0; i < completedTasks.size(); i++) {
            System.out.println((i + 1) + ". " + completedTasks.get(i));
        }
    }

    private static void viewPendingTasks() {
        System.out.println("Pending Tasks:");
        if (tasks.isEmpty()) {
            System.out.println("No pending tasks.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    private static void clearCompletedTasks() {
        completedTasks.clear();
        System.out.println("Completed tasks cleared.");
    }

    private static boolean isValidTaskNumber(int taskNumber) {
        return taskNumber >= 1 && taskNumber <= tasks.size();
    }

    private static void exitProgram() {
        scanner.close();
        System.out.println("Exiting Task Manager. Goodbye!");
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Tasks:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }
}
