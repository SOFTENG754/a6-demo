package nz.ac.auckland.se754.web.backend.model;

import java.util.List;

public class Lesson {

    private List<Task> tasks;
    private boolean isCompleted;
    public Lesson() {
    }

    public Lesson(List<Task> list) {
        this.tasks = list;
    }

    public List<Task> getFailedTasks() {
        return tasks.stream().filter(task -> !task.getIsCorrect()).toList();
    }

    public String getHintOnFailedTask(String task) {
        List<Task> failedTasks = getFailedTasks();
        Task failedTask = failedTasks.stream().filter(t -> t.getTitle().equals(task)).findFirst().orElse(null);
        return failedTask != null ? failedTask.getHint() : "";
    }

    public boolean redoTask(String task) {
        List<Task> failedTasks = getFailedTasks();
        return failedTasks.stream().anyMatch(t -> t.getTitle().equals(task));
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}
