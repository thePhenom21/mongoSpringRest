package com.example.mongotest.controller;

import com.example.mongotest.model.Todo;
import com.example.mongotest.repository.TodoRepository;
import org.apache.coyote.Request;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import java.util.List;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }


    @GetMapping("/todos")
    public ResponseEntity<List<Todo>> getTodos(){
        return ResponseEntity.ok(todoRepository.findAll());
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> createTodo(@RequestParam(name = "title") String title,@RequestParam(name = "task") String task, @RequestParam(name = "author") String author){
            Todo todo = new Todo();
            todo.setAuthor(author);
            todo.setTask(task);
            todo.setTitle(title);
            return ResponseEntity.ok(todoRepository.save(todo));
    }



}
