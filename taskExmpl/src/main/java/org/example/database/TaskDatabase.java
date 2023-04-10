package org.example.database;

import org.example.model.Task;
import org.example.model.Worker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * данный класс представляет собой БД задач (Task) для хранения и усправления задачами
 * так же класс содержит методы для добавления, получения, удаления, изменения и печати задач
 */
public class TaskDatabase {
    private List<Task> tasks;

    public TaskDatabase() {
        this.tasks = new ArrayList<>();
    }

    // метод добавления задачи в БД
    public void addTask(Task task) {
        tasks.add(task);
    }

    // возвращает задачу по ее id
    public Task getTaskById(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    // возвращает список всех задач в БД
    public List<Task> getAllTasks() {
        return tasks;
    }

    // удаляет задачу из БД по ее id
    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }

    // печатает все задачи, которые находятся в БД
    public void printAllTasks() {
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    // выдает все задачи из списка с сокращенными данными (П. 3)
    public String printAllTasksSummary() {
        List<Task> summaries = getAllTasks();
        StringBuilder sb = new StringBuilder();
        for (Task summary : summaries) {
            sb.append("Task id: ").append(summary.getId()).append(", Title: ")
                    .append(summary.getTitle()).append(", Status: ").append(summary.getStatus()).append("\n");
        }
        return sb.toString();
    }

    // выдает задачу по id с полным описанием (П. 4)
    public Task getTaskByIdWithDetails(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.println("полное описание задачи №: " + task.getId());
                System.out.println("\nTask ID: " + task.getId());
                System.out.println("Title: " + task.getTitle());
                System.out.println("Description: " + task.getDescription());
                System.out.println("Time: " + task.getTime());
                System.out.println("Status: " + task.getStatus());
                System.out.println("Performer: " + task.getPerformer());
                return task;
            }
        }
        return null;
    }

    // меняет задачу по id (все кроме id и performer) (П. 5)
    public void updateTask(int id, String title, String description, LocalDateTime time, TaskStatus status) {
        Task task = getTaskById(id);
        if (task == null) {
            System.out.println("Задание с id " + id + " не найдено");
            return;
        }
        task.setTitle(title);
        task.setDescription(description);
        task.setTime(time);
        task.setStatus(status);
        System.out.println("Задание с id " + id + " было успешно обновлено");
    }

    // назначает на задачу исполнителя по id (П. 6)
    public void setPerformerForTask(int id, Worker performer) {

        Task task = getTaskById(id);
        if (task == null) {
            System.out.println("Task with id " + id + " not found");
            return;
        }
        task.setPerformer(String.valueOf(performer));

    }
}
