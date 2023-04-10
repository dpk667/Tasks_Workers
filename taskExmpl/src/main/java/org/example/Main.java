package org.example;


import org.example.database.*;
import org.example.model.Task;
import org.example.model.Worker;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // создаем базу данных для задач
        TaskDatabase taskDatabase = new TaskDatabase();
        // создаем список задач
        List<Task> tasks = new ArrayList<>();

        // инициализируем сотрудников
        WorkerService workerService = new WorkerServiceImpl(new WorkerRepositoryImpl());

        // создаем очередь задач и отправляем в нее задачи (п.1)
        TaskQueueService taskQueue = new TaskQueueServiceImpl();

        //считываем 3 задачи из очереди и складываем их в БД тремя потоками (п.2)
        TaskProcessor taskProcessor = new TaskProcessor(taskQueue, taskDatabase, 3);

        // принимаем задачи и добавляем их в очередь
        taskQueue.addTask(new Task(1, "First tsk", "we need to develop new functionality", LocalDateTime.now(), TaskStatus.IN_PROGRESS, "Sidorov"));
        taskQueue.addTask(new Task(2, "Second task", "we need to fix all the bugs", LocalDateTime.now(), TaskStatus.DONE, "Petrov"));
        taskQueue.addTask(new Task(3, "Third task", "hold a conference call", LocalDateTime.now(), TaskStatus.TODO, "Ivanov"));

        // создаем двух сотрудников
        Worker worker1 = new Worker(1, "Dmitry Romanov", "Developer");
        Worker worker2 = new Worker(2, "Alexey Ignatiev", "Project Manager");

        // запускаем обработку задач
        taskProcessor.startProcessing();

        // эмулируем работу программы, ждем пока задачи добавляются в БД
        Thread.sleep(10000);

        // останавливаем обработку задач
        taskProcessor.stopProcessing();

        // все задачи из базы в списке с сокращенными данными  (п.3)
        System.out.println(taskDatabase.printAllTasksSummary());
        System.out.println("**********************************");

        // выдающий задачу по id с полным описанием (п.4)
        System.out.println(taskDatabase.getTaskByIdWithDetails(1));
        System.out.println("**********************************");

        // меняющий задачу по id (п.5)
        taskDatabase.updateTask(1, "Task of year", "description", LocalDateTime.now(), TaskStatus.DONE);
        taskDatabase.getTaskByIdWithDetails(1);

        // назначить на задачу исполнителя (п.6)
        taskDatabase.setPerformerForTask(1, worker1);
        System.out.println("***********************************");
        taskDatabase.getTaskByIdWithDetails(1);
        System.out.println("***********************************");

        // CRUD операции с сущностями Workers (п.7)
        // создаем сотрудника
        Worker worker = new Worker(99, "Fedor Sokolov", "Manager");

        // Добавление работника в репозиторий
        workerService.addWorker(worker);

        // Получение работника по ID
        System.out.println(workerService.getWorkerById(99));

        // Обновление информации о работнике
        workerService.getWorkerById(99).setName("Fedor Sokolov");
        workerService.getWorkerById(99).setPosition("Sales Manager");
        workerService.updateWorker(workerService.getWorkerById(99));
        System.out.println("обновленная информация о сотруднике: " + workerService.getWorkerById(99));

        // Удаление работника по ID
        workerService.deleteWorker(99);
    }
}