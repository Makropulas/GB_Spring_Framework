package ru.dmalomoshin.homework_12.service;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;
import ru.dmalomoshin.homework_12.model.Task;

@MessagingGateway(defaultRequestChannel = "taskInputChannel")
public interface FileGateway {
    void writeToFile(@Header(FileHeaders.FILENAME) String filename, Task task);
}
