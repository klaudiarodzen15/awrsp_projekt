import java.util.ArrayList;
import java.util.List;

public class CompletedTasksFilter implements TaskFilter{
    @Override
    public List<Task> filter(List<Task> tasks) {
        List<Task> completedTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }
        return completedTasks;
    }
}
