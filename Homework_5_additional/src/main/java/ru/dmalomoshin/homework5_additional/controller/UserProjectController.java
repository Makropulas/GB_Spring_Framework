package ru.dmalomoshin.homework5_additional.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.dmalomoshin.homework5_additional.domain.Project;
import ru.dmalomoshin.homework5_additional.domain.User;
import ru.dmalomoshin.homework5_additional.service.UserProjectService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserProjectController {

    private UserProjectService userProjectService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsersByProjectId(Long projectId) {
        return null;
    }

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjectsByUserId(Long userId) {
        return null;
    }

    @PostMapping("/users")
    public ResponseEntity addUserToProject(Long userId, Long projectId) {
        return null;
    }

    @PostMapping("/projects")
    public ResponseEntity removeUserFromProject(Long userId, Long projectId) {
        return null;
    }

}
