package dev.HelloWorld.service;
import dev.HelloWorld.models.Todo;

import java.util.List;
import dev.HelloWorld.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository todoRepository;

    //To reduce the below code usage we are using the Inversion of Control using the Auto wiring concepts
    /*
    public ToDoService(){
        toDoRepository = new ToDoRepository();
    }
     */

    public Todo createTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id).orElseThrow(()-> new RuntimeException("ToDo Not Found"));
    }

    public Page<Todo> getAllTodosPages(int page,int size){
        Pageable pageable = PageRequest.of(page,size);
        return todoRepository.findAll(pageable);
    }

    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    public Todo updateTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id){
        todoRepository.delete(getTodoById(id));
    }

}
