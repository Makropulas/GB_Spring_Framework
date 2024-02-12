package ru.dmalomoshin.homework5_additional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmalomoshin.homework5_additional.domain.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
