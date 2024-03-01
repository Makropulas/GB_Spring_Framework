package ru.dmalomoshin.homework10.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.dmalomoshin.homework10.domain.Note;
import ru.dmalomoshin.homework10.exception_handling.NoSuchNoteException;
import ru.dmalomoshin.homework10.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @Mock
    private NoteRepository noteRepository;

    @InjectMocks
    private NoteServiceImpl noteService;

    private Note testNote;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        testNote = new Note();
        testNote.setId(1L);
        testNote.setTitle("Note_title");
        testNote.setContent("Note_content");
    }

    @Test
    void createNote_ShouldWorkOnce() {
        noteService.createNote(testNote);

        verify(noteRepository, times(1)).save(testNote);
    }

    @Test
    void getAllNotes_ShouldReturnCorrectList() {
        Note secondNote = new Note();
        List<Note> noteList = List.of(testNote, secondNote);

        given(noteRepository.findAll()).willReturn(noteList);

        List<Note> receivedList =  noteService.getAllNotes();

        assertEquals(2, receivedList.size());
    }

    @Test
    void getNoteFromId_ShouldReturnCorrectId() {

        given(noteRepository.findById(testNote.getId())).willReturn(Optional.of(testNote));

        Note foundNote = noteService.getNoteFromId(1L);

        assertEquals(1L, foundNote.getId());
    }

    @Test
    void getNoteFromId_ShouldThrowException() {
        assertThrows(NoSuchNoteException.class, () -> noteService.getNoteFromId(1L));
    }

    @Test
    void updateNote_ShouldCallCorrectMethod() {
        Long id = 1L;
        Note updatedNote = new Note();
        updatedNote.setContent("Updated_content");

        given(noteRepository.findById(id)).willReturn(Optional.of(testNote));

        noteService.updateNote(id, updatedNote);

        verify(noteRepository).save(testNote);
    }

    @Test
    void deleteNote_ShouldCallCorrectMethod() {
        Long id = 1L;

        given(noteRepository.findById(testNote.getId())).willReturn(Optional.of(testNote));

        noteService.deleteNote(id);

        verify(noteRepository).deleteById(id);
    }
}