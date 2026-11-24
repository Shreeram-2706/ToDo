package dev.HelloWorld;

import dev.HelloWorld.service.ToDoService;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ToDoService toDoService = new ToDoService();

    }
}
