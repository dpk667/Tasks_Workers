# Tasks_Workers
For launch this project, run Main.java in ur IDE


# TASK
Write a service that implements the following REST methods to work with tasks (for example fields id, title, description, time, status, performer) and performers (id, name, position, avatar (img)):

1) taking a task and putting it into a queue, implemented in the service, by java tools.(without external MQ, etc.)
2) reading 3 tasks from the implemented queue and stacking them in the database with multiple threads (PG or Oracle).
3) issuing all tasks from database in a list with abbreviated data (id, title, status).
4) issuing task by id with full description.
5) modifying a task by its id (everything except id and performer).
6) Assigning performer to the task.
7) CRUD operations with task entities. Don't forget to show brief information on the tasks assigned to the performer.
