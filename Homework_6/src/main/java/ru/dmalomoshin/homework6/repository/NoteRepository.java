package ru.dmalomoshin.homework6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmalomoshin.homework6.domain.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
