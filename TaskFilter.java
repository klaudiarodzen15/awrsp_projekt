import java.util.List;

public interface TaskFilter {
    List<Task> filter(List<Task> tasks);
}
