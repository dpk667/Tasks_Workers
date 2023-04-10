package org.example.database;

import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * данный класс отвечает за обработку задач, содержащихся в БД
 * позволяет создавать новые задачи, просматривать, изменять и удалять существующие
 * так же позволяет просматривать список всех задач и получить крааткие сведения о них
 */
public class TaskProcessor {
    private final TaskQueueService taskQueue;
    private final TaskDatabase taskDatabase;
    private final int countThreads;
    private List<Thread> threads;


    public TaskProcessor(TaskQueueService taskQueue, TaskDatabase taskDatabase, int countThreads) {
        this.taskQueue = taskQueue;
        this.taskDatabase = taskDatabase;
        this.countThreads = countThreads;
        this.threads = new ArrayList<>();
    }


    // метод считывающий 3 задачи из реализованной очереди и складывающий их в БД несколькими потоками
    public void processTasks() {
        for (int i = 0; i < countThreads; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!Thread.interrupted()) {
                        Task task = taskQueue.getNextTask();
                        if (task == null) {
                            break;
                        }
                        taskDatabase.addTask(task);
                    }
                }
            });
            threads.add(thread);
            thread.start();
        }
    }

    // метод для завершения потока
    public void stopProcessing() {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }

    // метод для старта потока
    public void startProcessing() {
        processTasks();
    }
}

