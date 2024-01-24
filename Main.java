import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        // Przykładowa logika zarządzania zadaniami
        TaskList taskList = new TaskList();
        TaskHelper taskHelper = new TaskHelper();
        TaskFileHelper fileHelper = new TaskFileHelper();

        taskList.addTask(new Task("Task 1", "Description 1", LocalDate.now()));
        taskList.addTask(new Task("Task 2", "Description 2", LocalDate.now().plusDays(1)));
        taskList.addTask(new Task("Task 3", "Description 3", LocalDate.now().plusDays(2)));

        System.out.println("All Tasks:");
        for (Task task : taskList.getTasks()) {
            System.out.println(task.getTitle());
        }

        int taskIdToComplete = 1;
        taskHelper.completeTask(taskIdToComplete, taskList);
        System.out.println("\nPending Tasks:");
        TaskFilter pendingTasksFilter = new PendingTasksFilter();
        for (Task task : taskList.filterTasks(pendingTasksFilter)) {
            System.out.println(task.getTitle());
        }

        String fileName = "tasks.txt";
        fileHelper.saveTasksToFile(taskList.getTasks(), fileName);
        List<Task> loadedTasks = fileHelper.readTasksFromFile(fileName);
        System.out.println("\nLoaded Tasks from File:");
        for (Task task : loadedTasks) {
            System.out.println(task.getTitle());
        }
    }
}