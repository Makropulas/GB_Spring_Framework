package ru.dmalomoshin.homework10.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class NoteGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<NoteIncorrectData> handleException(NoSuchNoteException exception) {
        NoteIncorrectData incorrectData = new NoteIncorrectData();
        incorrectData.setInfo(exception.getMessage());

        return new ResponseEntity<>(incorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<NoteIncorrectData> handleException(Exception exception) {
        NoteIncorrectData incorrectData = new NoteIncorrectData();
        incorrectData.setInfo(exception.getMessage());

        return new ResponseEntity<>(incorrectData, HttpStatus.BAD_REQUEST);
    }

}
