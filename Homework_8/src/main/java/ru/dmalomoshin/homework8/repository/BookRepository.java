package ru.dmalomoshin.homework8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmalomoshin.homework8.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
