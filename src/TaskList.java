import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void updateTask(int index, String description) {
        Task updateTask = this.taskList.get(index);
        updateTask.setDescription(description);
        updateTask.setUpdatedAt();
    }

    public void removeTask(int index) {
        this.taskList.remove(index);
    }

    public int getListSize() {
        return this.taskList.size();
    }

    public boolean isListIndexValid(int index) {
        if (this.taskList.isEmpty() || index < 0 || index > this.taskList.size()) {
            return false;
        } else {
            return true;
        }
    }

    public List<Task> allTasks() {
        return this.taskList;
    }
}
