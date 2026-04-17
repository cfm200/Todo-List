import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TaskList taskList;

    public UserInterface(Scanner scanner, TaskList taskList) {
        this.scanner = scanner;
        this.taskList = taskList;
    }

    public void start() {
        int count = 0;
        while (true) {
            System.out.println("Options: add, update, delete, mark-done, mark-in-progress");
            String input = this.scanner.nextLine();

            if (input.equals("quit")) {
                break;
            }

            if (input.equals("add")) {
                System.out.print("Task: ");
                String description = this.scanner.nextLine();
                Task task = new Task(description);
                this.taskList.addTask(task);
            } else if (input.equals("update")) {
                System.out.print("Index: ");
                int index = Integer.valueOf(this.scanner.nextLine());
                if (index > this.taskList.allTasks().size() || index < 0) {
                    System.out.println("Invalid index: 0 - " + this.taskList.allTasks().size());
                    continue;
                }
                System.out.print("Update description: ");
                String description = this.scanner.nextLine();
                this.taskList.updateTask(index, description);
            } else if (input.equals("delete")) {
                System.out.print("Index: ");
                int index = Integer.valueOf(this.scanner.nextLine());
                if (index > this.taskList.allTasks().size() || index < 0) {
                    System.out.println("Invalid index: 0 - " + this.taskList.allTasks().size());
                    continue;
                }
                this.taskList.removeTask(index);
            } else if (input.equals("mark-done")) {
                System.out.print("Index: ");
                int index = Integer.valueOf(this.scanner.nextLine());
                if (index > this.taskList.allTasks().size() || index < 0) {
                    System.out.println("Invalid index: 0 - " + this.taskList.allTasks().size());
                    continue;
                }
                for (Task task : this.taskList.allTasks()) {
                    if (count == index) {
                        task.setStatus("done");
                        task.setUpdatedAt();
                        count = 0;
                        break;
                    } else {
                        count++;
                    }
                }
            } else if (input.equals("mark-in-progress")) {
                System.out.print("Index: ");
                int index = Integer.valueOf(this.scanner.nextLine());
                if (index > this.taskList.allTasks().size() || index < 0) {
                    System.out.println("Invalid index: 0 - " + this.taskList.allTasks().size());
                    continue;
                }
                for (Task task : this.taskList.allTasks()) {
                    if (count == index) {
                        task.setStatus("in-progress");
                        task.setUpdatedAt();
                        count = 0;
                        break;
                    } else {
                        count++;
                    }
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }

        for (Task task : this.taskList.allTasks()) {
            System.out.println(task);
        }
    }
}
