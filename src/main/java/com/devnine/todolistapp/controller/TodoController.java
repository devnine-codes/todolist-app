package com.devnine.todolistapp.controller;

import com.devnine.todolistapp.model.Todo;
import com.devnine.todolistapp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/user/{userId}")
    public List<Todo> getTodosByUserId(@PathVariable Long userId) {
        return todoService.getTodosByUserId(userId);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

    @GetMapping("/search")
    public List<Todo> searchTodos(@RequestParam String keyword) {
        return todoService.searchByKeyword(keyword);
    }

    @PutMapping("/{id}/toggle")
    public Todo toggleTodoCompleted(@PathVariable Long id) {
        Todo todo = todoService.getTodoById(id);
        todo.setCompleted(!todo.isCompleted());
        return todoService.createTodo(todo);
    }
}
