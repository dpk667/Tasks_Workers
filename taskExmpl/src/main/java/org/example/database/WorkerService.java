package org.example.database;

import org.example.model.Worker;

import java.util.List;

/**
 * данный интерфейс реализует логику работы с данными о сотрудниках
 * выполняет CRUD методы для объектов Worker
 */
public interface WorkerService {

    void addWorker(Worker worker);

    Worker getWorkerById(int id);

    List<Worker> getAllWorkers();

    void updateWorker(Worker worker);

    void deleteWorker(int id);

}