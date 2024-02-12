package ru.dmalomoshin.homework5_additional.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmalomoshin.homework5_additional.domain.Project;
import ru.dmalomoshin.homework5_additional.domain.User;
import ru.dmalomoshin.homework5_additional.repository.UsersProjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserProjectService {

    private UsersProjectRepository usersProjectRepository;

    public List<User> getUsersByProjectId(Long projectId) {
        return null;
    }

    public List<Project> getProjectsByUserId(Long userId) {
        return null;
    }

    public void addUserToProject(Long userId, Long projectId) {

    }

    public void removeUserFromProject(Long userId, Long projectId) {

    }
}
