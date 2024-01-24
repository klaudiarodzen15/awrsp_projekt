import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskFileHelper {
    public void saveTasksToFile(List<Task> tasks, String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Task task : tasks) {
                writer.println(task.getId() + ";" + task.getTitle() + ";" + task.getDescription() + ";"
                        + task.getDueDate() + ";" + task.isCompleted());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Task> readTasksFromFile(String fileName) {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String description = parts[2];
                LocalDate dueDate = LocalDate.parse(parts[3]);
                boolean completed = Boolean.parseBoolean(parts[4]);
                Task task = new Task(title, description, dueDate);
                task.setCompleted(completed);
                tasks.add(task);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
    }
}
