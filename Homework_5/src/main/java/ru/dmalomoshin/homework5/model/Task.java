package ru.dmalomoshin.homework5.model;

import jakarta.persistence.*;
import lombok.Data;
import ru.dmalomoshin.homework5.status.TaskStatus;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    private TaskStatus status;

    @Column(name = "date_of_creation")
    private LocalDateTime creationDate;

}
