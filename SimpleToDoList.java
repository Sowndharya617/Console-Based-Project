import java.util.ArrayList;
import java.util.Scanner;

// Simple To-Do List App
public class SimpleToDoList {

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>(); // List of tasks
        ArrayList<Boolean> taskStatus = new ArrayList<>(); // Task statuses: true = completed, false = pending
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Show options
            System.out.println("Choose an option:");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            int userInput = scanner.nextInt();
            scanner.nextLine(); // Clear input buffer

            switch (userInput) {
                case 1: // Add a task
                    System.out.print("Enter the task: ");
                    String newTask = scanner.nextLine();
                    tasks.add(newTask); // Add task to the list
                    taskStatus.add(false); // Mark as pending
                    System.out.println("Task added.");
                    break;

                case 2: // Show all tasks
                    System.out.println("Your Tasks:");
                    if (tasks.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            String status = taskStatus.get(i) ? "Completed" : "Pending";
                            System.out.println((i + 1) + ". " + tasks.get(i) + " [" + status + "]");
                        }
                    }
                    break;

                case 3: // Mark a task as completed
                    System.out.print("Enter task number to mark as completed: ");
                    int taskNumber = scanner.nextInt();
                    if (taskNumber > 0 && taskNumber <= tasks.size()) {
                        taskStatus.set(taskNumber - 1, true); // Update status
                        System.out.println("Task marked as completed.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4: // Delete a task
                    System.out.print("Enter task number to delete: ");
                    int deleteTaskNumber = scanner.nextInt();
                    if (deleteTaskNumber > 0 && deleteTaskNumber <= tasks.size()) {
                        tasks.remove(deleteTaskNumber - 1); // Remove task
                        taskStatus.remove(deleteTaskNumber - 1); // Remove status
                        System.out.println("Task deleted.");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 5: // Exit the program
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default: // Handle invalid input
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
    }
}
