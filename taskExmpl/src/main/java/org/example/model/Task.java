package org.example.model;

import org.example.database.TaskStatus;

import java.time.LocalDateTime;


/**
 * данный класс представляет собой задачу (task)
 * содержит информацию о заголовке, описании, времени создания, статусе и исполнителе
 */
public class Task {
    private int id;
    private String title;
    private String description;
    private LocalDateTime time;
    private TaskStatus status;
    private String performer;

    public Task(int id, String title, String description, LocalDateTime time, TaskStatus status, String performer) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.time = time;
        this.status = status;
        this.performer = performer;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    @Override
    public String toString() {
        return "Task ID: " + id + ", Title: " + title + ", Description: " + description + ", Date: " + time +
                ", Status: " + status + ", Assignee: " + performer;
    }
}
