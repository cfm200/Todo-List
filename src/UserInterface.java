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
            System.out.println("Options: add, update, delete, mark-done, mark-in-progress, quit");
            String input = this.scanner.nextLine();

            switch (input) {
                case "quit":
                    if (this.taskList.getListSize() == 0) {
                        System.out.println("No tasks found.");
                        return;
                    }

                    for (Task task : this.taskList.allTasks()) {
                        System.out.println(task);
                    }
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
                    if (this.taskList.isListIndexValid(updateIndex)) {
                        System.out.print("Update description: ");
                        String updateDescription = this.scanner.nextLine();
                        this.taskList.updateTask(updateIndex, updateDescription);
                        continue;
                    } else {
                        System.out.println("Invalid index: 0 - " + (this.taskList.getListSize() - 1));
                        continue;
                    }

                case "delete":
                    System.out.print("Index: ");
                    int deleteIndex = Integer.valueOf(this.scanner.nextLine());
                    if (this.taskList.isListIndexValid(deleteIndex)) {
                        this.taskList.removeTask(deleteIndex);
                        continue;
                    } else {
                        System.out.println("Invalid index: 0 - " + (this.taskList.getListSize() - 1));
                        continue;
                    }

                case "mark-done":
                    System.out.print("Index: ");
                    int doneIndex = Integer.valueOf(this.scanner.nextLine());
                    if (this.taskList.isListIndexValid(doneIndex)) {
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
                    } else {
                        System.out.println("Invalid index: 0 - " + (this.taskList.getListSize() - 1));
                        continue;
                    }

                case "mark-in-progress":
                    System.out.print("Index: ");
                    int inProgressIndex = Integer.valueOf(this.scanner.nextLine());
                    if (this.taskList.isListIndexValid(inProgressIndex)) {
                        for (Task inProgressTask : this.taskList.allTasks()) {
                            if (count == inProgressIndex) {
                                inProgressTask.setStatus("in-progress");
                                inProgressTask.setUpdatedAt();
                                count = 0;
                                break;
                            } else {
                                count++;
                            }
                        }
                        continue;
                    } else {
                        System.out.println("Invalid index: 0 - " + (this.taskList.getListSize() - 1));
                        continue;
                    }
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
