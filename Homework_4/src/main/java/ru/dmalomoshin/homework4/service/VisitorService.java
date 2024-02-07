package ru.dmalomoshin.homework4.service;

import org.springframework.stereotype.Service;
import ru.dmalomoshin.homework4.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

@Service
public class VisitorService {
    private final List<Visitor> visitors = new ArrayList<>();

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public List<Visitor> allVisitors() {
        return visitors;
    }
}
