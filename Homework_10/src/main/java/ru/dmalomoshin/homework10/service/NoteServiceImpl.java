package ru.dmalomoshin.homework10.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmalomoshin.homework10.domain.Note;
import ru.dmalomoshin.homework10.exception_handling.NoSuchNoteException;
import ru.dmalomoshin.homework10.repository.NoteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteServiceImpl implements NoteService {

    private NoteRepository repository;

    @Override
    public Note createNote(Note note) {
        return repository.save(note);
    }

    @Override
    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    @Override
    public Note getNoteFromId(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchNoteException(id));
    }

    @Override
    public Note updateNote(Long id, Note updatedNote) {
        Note note = getNoteFromId(id);
        note.setContent(updatedNote.getContent());

        return repository.save(note);
    }

    @Override
    public void deleteNote(Long id) {
        Note note = getNoteFromId(id);
        repository.deleteById(id);
    }
}
