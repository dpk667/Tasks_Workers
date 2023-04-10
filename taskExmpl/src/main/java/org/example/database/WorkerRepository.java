package org.example.database;

import org.example.model.Worker;

import java.util.List;

/**
 * данный интерфейс предназначен для работы с данными о сотрудниках
 * он выполняет CRUD задачи для сущности Worker
 */
public interface WorkerRepository {

    void addWorker(Worker worker);

    Worker getWorkerById(int id);

    List<Worker> getAllWorkers();

    void updateWorker(Worker worker);

    void deleteWorker(int id);
}
