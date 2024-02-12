package ru.dmalomoshin.homework5_additional.relation;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class UsersProject extends EntitiyWithRelation {

    private Long projectId;

    private Long userId;

}
