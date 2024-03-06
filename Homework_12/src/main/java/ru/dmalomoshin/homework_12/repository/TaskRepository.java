package ru.dmalomoshin.homework_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmalomoshin.homework_12.model.Task;
import ru.dmalomoshin.homework_12.model.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByStatus(TaskStatus status);
}
