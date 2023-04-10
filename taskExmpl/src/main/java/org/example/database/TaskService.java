package org.example.database;

import org.example.model.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Queue;


/**
 * данный интерфейс отвечает за работу с задачами:
 * с его помощью мы реализуем CRUD операции, можем получить список задач с их сведениями и пр.
 */

public interface TaskService {
    void createTask(Task task);

    Task getTaskById(int id);

    List<Task> getAllTasks();

    void deleteTask(int id);

    Queue<Task> getTaskQueue();

    void addTaskToQueue(Task task);

    void updateTask(int id, String title, String description, LocalDateTime time, TaskStatus status);


}
