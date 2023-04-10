package org.example.database;

import org.example.database.WorkerRepository;
import org.example.database.WorkerService;
import org.example.model.Worker;

import java.util.List;


/**
 * данный класс реализует интерфейс WorkerService
 * при помощи данного класса мы имеем возможность получать информацию о сотрудниках, используя хранилище данных WorkerRepository
 */
public class WorkerServiceImpl implements WorkerService {

    private WorkerRepository workerRepository;

    public WorkerServiceImpl(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Override
    public void addWorker(Worker worker) {
        workerRepository.addWorker(worker);
    }

    @Override
    public Worker getWorkerById(int id) {
        return workerRepository.getWorkerById(id);
    }

    @Override
    public List<Worker> getAllWorkers() {
        return workerRepository.getAllWorkers();
    }

    @Override
    public void updateWorker(Worker worker) {
        workerRepository.updateWorker(worker);
    }

    @Override
    public void deleteWorker(int id) {
        workerRepository.deleteWorker(id);
    }

}

