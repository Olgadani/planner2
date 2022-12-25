import java.time.LocalDate;
import java.util.*;

public class TaskList {
    private final Map<Integer, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        tasks.put(task.getId(), task);
    }

    public void removeTask(int id) {
        this.tasks.remove(id);
    }

    public Collection<Task> getTasksForDay(LocalDate date){
        List<Task> taskForDay = new ArrayList<>();
        for (Task task : tasks.values()) {
            if (task.appersIn(date)) {
                taskForDay.add(task);
            }
        }
        return taskForDay;
    }

}
