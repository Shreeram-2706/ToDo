package dev.HelloWorld.controller;

import dev.HelloWorld.service.ToDoService;
import dev.HelloWorld.models.Todo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todo")
@Slf4j
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Todo Successfully Created"),
            @ApiResponse(responseCode = "404", description = "Response Not Found")
    })
    @GetMapping("/{id}")
    ResponseEntity<Todo> getTodoById(@PathVariable long id) {
        try {
            Todo createdTodo = toDoService.getTodoById(id);
            return new ResponseEntity<>(createdTodo, HttpStatus.OK);
        } catch (RuntimeException exception) {
            return new ResponseEntity<Todo>((Todo) null, HttpStatus.NOT_FOUND);
        }
    }

    @ApiResponse(responseCode = "200", description = "All Retrieved Successfully")
    @GetMapping
    ResponseEntity<List<Todo>> getTodos(){
        return new ResponseEntity<>(toDoService.getTodos(), HttpStatus.OK);
    }

    @GetMapping("/page")
    ResponseEntity<Page<Todo>> getTodosPaged(@RequestParam int page, @RequestParam int size){
        return new ResponseEntity<>(toDoService.getAllTodosPages(page,size), HttpStatus.OK);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Document created successfully")
    })

    @PostMapping("/create")
    ResponseEntity<Todo> createUser(@RequestBody Todo todo) {
        Todo createdTodo = toDoService.createTodo(todo);
        return new ResponseEntity<>(createdTodo,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> updateTodoById(@PathVariable long id, @RequestBody Todo todo){
        todo.setId(id);
        return new ResponseEntity<>(toDoService.updateTodo(todo), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    void deleteTodoById(@PathVariable long id){
        toDoService.deleteTodoById((id));
    }
}
