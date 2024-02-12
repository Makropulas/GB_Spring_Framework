package ru.dmalomoshin.homework5_additional.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmalomoshin.homework5_additional.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
