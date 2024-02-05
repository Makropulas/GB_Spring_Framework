package ru.dmalomoshin.homework3.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.dmalomoshin.homework3.domain.User;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> getUsers() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setName(r.getString("name"));
            rowObject.setAge(r.getInt("age"));
            rowObject.setEmail(r.getString("email"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public void addUser(User user) {
        String sql = "INSERT INTO userTable (name,age,email) VALUES (?,?,?)";
        jdbc.update(sql, user.getName(), user.getAge(), user.getEmail());
    }
}