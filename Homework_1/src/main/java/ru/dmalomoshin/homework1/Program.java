package ru.dmalomoshin.homework1;

import com.google.gson.Gson;
import ru.dmalomoshin.homework1.domain.Person;

public class Program {
    public static void main(String[] args) {
        Person person = new Person("Dmitry", "Malomoshin", 36);

        Gson gson = new Gson();

        // Сериализация объекта класса Person в формат JSON
        String json = gson.toJson(person);

        // Десериализация объекта класса Person из формата JSON
        Person newPerson = gson.fromJson(json, Person.class);

        // Демонстрация того, что десериализованный из JSON объект равен тому, из которого он был сериализован
        String conclusion = person.equals(newPerson) ? "Объекты равны" : "Объекты отличаются";
        System.out.println(conclusion);
    }
}