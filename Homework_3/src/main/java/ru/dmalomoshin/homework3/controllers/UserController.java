package ru.dmalomoshin.homework3.controllers;

import org.springframework.web.bind.annotation.*;
import ru.dmalomoshin.homework3.domain.User;
import ru.dmalomoshin.homework3.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final RegistrationService service;

    public UserController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> userList() {
        return service.getDataProcessingService().getRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.getDataProcessingService().getRepository().getUsers().add(user);
        return "User added from body!";
    }

    @PostMapping("/param")
    public String userAddFromParam(@RequestParam String name, @RequestParam int age, @RequestParam String email) {
        service.processRegistration(name, age, email);
        return "User added from param!";
    }
}