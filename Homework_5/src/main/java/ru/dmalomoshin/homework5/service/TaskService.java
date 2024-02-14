package ru.dmalomoshin.homework5.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmalomoshin.homework5.model.Task;
import ru.dmalomoshin.homework5.repository.TaskRepository;
import ru.dmalomoshin.homework5.model.TaskStatus;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task addTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return repository.findAllByStatus(status);
    }

    public Task updateTaskStatus(Long id, Task newTask) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            task.setStatus(newTask.getStatus());
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}
