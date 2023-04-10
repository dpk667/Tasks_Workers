package org.example.database;

import org.example.model.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Queue;

/**
 * данный класс служит реализацией TaskService
 */
public class TaskServiceImpl implements TaskService {
    private final TaskDatabase taskDatabase;
    private final Queue<Task> taskQueue;

    public TaskServiceImpl(TaskDatabase taskDatabase, Queue<Task> taskQueue) {
        this.taskDatabase = taskDatabase;
        this.taskQueue = taskQueue;
    }

    @Override
    public void createTask(Task task) {
        taskDatabase.addTask(task);
    }

    @Override
    public Task getTaskById(int id) {
        return taskDatabase.getTaskById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskDatabase.getAllTasks();
    }

    @Override
    public void deleteTask(int id) {
        taskDatabase.deleteTask(id);
    }

    @Override
    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }

    @Override
    public void addTaskToQueue(Task task) {
        taskQueue.add(task);
    }

    @Override
    public void updateTask(int id, String title, String description, LocalDateTime time, TaskStatus status) {
        taskDatabase.updateTask(id, title, description, time, status);
    }


}