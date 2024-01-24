import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskHelper {
    public void completeTask(int taskId, TaskList taskList) {
        for (Task task : taskList.getTasks()) {
            if (task.getId() == taskId) {
                task.setCompleted(true);
                break;
            }
        }
    }

    public void displayTaskDetails(int taskId, TaskList taskList) {
        for (Task task : taskList.getTasks()) {
            if (task.getId() == taskId) {
                System.out.println("Task ID: " + task.getId());
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Due Date: " + task.getDueDate());
                System.out.println("Completed: " + task.isCompleted());
                break;
            }
        }
    }
}
