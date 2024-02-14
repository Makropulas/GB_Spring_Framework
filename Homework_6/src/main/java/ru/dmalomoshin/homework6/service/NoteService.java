package ru.dmalomoshin.homework6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmalomoshin.homework6.domain.Note;
import ru.dmalomoshin.homework6.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService implements iNoteService{

    private NoteRepository repository;

    @Override
    public Note addNote(Note note) {
        return repository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Optional<Note> getNoteFromId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Note updateNote(Note note) {
        return null;
    }

    @Override
    public void deleteNote(Long id) {

    }
}
