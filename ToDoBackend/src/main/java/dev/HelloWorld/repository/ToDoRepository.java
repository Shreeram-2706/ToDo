package dev.HelloWorld.repository;

import dev.HelloWorld.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ToDoRepository extends JpaRepository<Todo, Long> {


}
