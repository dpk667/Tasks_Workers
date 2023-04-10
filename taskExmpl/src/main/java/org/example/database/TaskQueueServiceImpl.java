package org.example.database;

import org.example.model.Task;

import java.util.LinkedList;
import java.util.Queue;

/**
 * данный класс служит реализацией интерфейса TaskQueueService
 */
public class TaskQueueServiceImpl implements TaskQueueService {

    private Queue<Task> taskQueue;

    public TaskQueueServiceImpl() {
        taskQueue = new LinkedList<>();
    }

    @Override
    public void addTask(Task task) {
        taskQueue.add(task);
    }

    public Task getNextTask() {
        return taskQueue.poll();
    }

    public int getTaskCount() {
        return taskQueue.size();
    }

    @Override
    public boolean add(Task task) {
        return taskQueue.add(task);
    }

    @Override
    public boolean offer(Task task) {
        return taskQueue.offer(task);
    }

    @Override
    public Task remove() {
        return taskQueue.remove();
    }

    @Override
    public Task element() {
        return taskQueue.element();
    }

    @Override
    public Task peek() {
        return taskQueue.peek();
    }
}
