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

            switch (input) {
                case "quit":
                    System.out.println("Bye bye!");
                    return;
                case "add":
                    System.out.print("Task: ");
                    String description = this.scanner.nextLine();
                    Task task = new Task(description);
                    this.taskList.addTask(task);
                    continue;

                case "update":
                    System.out.print("Index: ");
                    int updateIndex = Integer.valueOf(this.scanner.nextLine());
                    if (updateIndex > this.taskList.allTasks().size() || updateIndex < 0) {
                        System.out.println("Invalid index: 0 - " + this.taskList.allTasks().size());
                        continue;
                    }
                    System.out.print("Update description: ");
                    String updateDescription = this.scanner.nextLine();
                    this.taskList.updateTask(updateIndex, updateDescription);
                    continue;

                case "delete":
                    System.out.print("Index: ");
                    int deleteIndex = Integer.valueOf(this.scanner.nextLine());
                    if (deleteIndex > this.taskList.allTasks().size() || deleteIndex < 0) {
                        System.out.println("Invalid index: 0 - " + this.taskList.allTasks().size());
                        continue;
                    }
                    this.taskList.removeTask(deleteIndex);
                    continue;

                case "mark-done":
                    System.out.print("Index: ");
                    int doneIndex = Integer.valueOf(this.scanner.nextLine());
                    if (doneIndex > this.taskList.allTasks().size() || doneIndex < 0) {
                        System.out.println("Invalid index: 0 - " + this.taskList.allTasks().size());
                        continue;
                    }
                    for (Task doneTask : this.taskList.allTasks()) {
                        if (count == doneIndex) {
                            doneTask.setStatus("done");
                            doneTask.setUpdatedAt();
                            count = 0;
                            break;
                        } else {
                            count++;
                        }
                    }
                    continue;

                case "mark-in-progress":
                    System.out.print("Index: ");
                    int index = Integer.valueOf(this.scanner.nextLine());
                    if (index > this.taskList.allTasks().size() || index < 0) {
                        System.out.println("Invalid index: 0 - " + this.taskList.allTasks().size());
                        continue;
                    }
                    for (Task inProgressTask : this.taskList.allTasks()) {
                        if (count == index) {
                            inProgressTask.setStatus("in-progress");
                            inProgressTask.setUpdatedAt();
                            count = 0;
                            break;
                        } else {
                            count++;
                        }
                    }
                    continue;
                default:
                    System.out.println("Invalid choice.");
            }

            for (Task task : this.taskList.allTasks()) {
                System.out.println(task);
            }
        }
    }
}
