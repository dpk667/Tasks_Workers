package org.example.database;

import org.example.database.WorkerRepository;
import org.example.model.Worker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * данный интерфейс необходим для выполнения CRUD операций с объектом Worker
  */

public class WorkerRepositoryImpl implements WorkerRepository {

    private Map<Integer, Worker> workers = new HashMap<>();

    @Override
    public void addWorker(Worker worker) {
        workers.put(worker.getId(), worker);
    }

    @Override
    public Worker getWorkerById(int id) {
        return workers.get(id);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return new ArrayList<>(workers.values());
    }

    @Override
    public void updateWorker(Worker worker) {
        workers.put(worker.getId(), worker);
    }

    @Override
    public void deleteWorker(int id) {
        workers.remove(id);
    }
}
