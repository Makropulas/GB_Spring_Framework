package ru.dmalomoshin.homework10.exception_handling;

public class NoSuchNoteException extends RuntimeException{
    public NoSuchNoteException(Long id) {
        super("Заметка с id " + id + " не найдена");
    }
}
