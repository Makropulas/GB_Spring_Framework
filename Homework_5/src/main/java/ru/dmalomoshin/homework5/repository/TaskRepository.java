package ru.dmalomoshin.homework5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.dmalomoshin.homework5.model.Task;
import ru.dmalomoshin.homework5.status.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
//    @Query("SELECT * FROM tasks WHERE status = :status") // тут подчёркивает звёздочку
    List<Task> findAllByStatus(TaskStatus status);

    // этот способ вообще не работает, подчёркивает всё подряд
//    @Modifying
//    @Query("UPDATE tasks SET status = :status WHERE id = :id")
//    Task updateStatus(Long id, TaskStatus status);
}
