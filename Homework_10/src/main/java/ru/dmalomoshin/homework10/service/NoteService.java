package ru.dmalomoshin.homework10.service;

import ru.dmalomoshin.homework10.domain.Note;

import java.util.List;

public interface NoteService {

    Note createNote(Note note);

    List<Note> getAllNotes();

    Note getNoteFromId(Long id);

    Note updateNote(Long id, Note note);

    void deleteNote(Long id);

}
