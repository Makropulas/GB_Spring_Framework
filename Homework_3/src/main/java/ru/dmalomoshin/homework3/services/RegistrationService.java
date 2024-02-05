package ru.dmalomoshin.homework3.services;

import org.springframework.stereotype.Service;
import ru.dmalomoshin.homework3.domain.User;

@Service
public class RegistrationService {
    private final UserService userService;
    private final NotificationService notificationService;
    private final DataProcessingService dataProcessingService;

    public RegistrationService(UserService userService, NotificationService notificationService, DataProcessingService dataProcessingService) {
        this.userService = userService;
        this.notificationService = notificationService;
        this.dataProcessingService = dataProcessingService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("User '" + user + "' added");
    }
}