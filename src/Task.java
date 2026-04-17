import java.util.UUID;
import java.time.LocalDateTime;

public class Task {
    private String id;
    private String description;
    private String status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Task(String description) {
        this.id = UUID.randomUUID().toString().replace("-", "");
        this.description = description;
        this.status = "todo";
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public String toString() {
        return "--------------------------------------------------\n" + this.id + ": " + this.description + "\nStatus: " + this.status + "\nCreated: " + this.createdAt + "\nUpdated: " + this.updatedAt + "\n----------------------------------------\n";
    }
}
