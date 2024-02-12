package ru.dmalomoshin.homework5_additional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmalomoshin.homework5_additional.relation.UsersProject;

public interface UsersProjectRepository extends JpaRepository<UsersProject, Long> {
}
