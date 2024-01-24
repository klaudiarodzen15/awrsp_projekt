import java.util.ArrayList;
import java.util.List;

public class PendingTasksFilter implements TaskFilter{
    @Override
    public List<Task> filter(List<Task> tasks) {
        List<Task> pendingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pendingTasks.add(task);
            }
        }
        return pendingTasks;
    }
}
