package com.devnine.todolistapp.service;

import com.devnine.todolistapp.exception.TodoNotFoundException;
import com.devnine.todolistapp.exception.UserNotFoundException;
import com.devnine.todolistapp.model.Todo;
import com.devnine.todolistapp.repository.TodoRepository;
import com.devnine.todolistapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private UserService userService;  // UserService 주입

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public List<Todo> getTodosByUserId(Long userId) {
        if (!userService.existsById(userId)) {
            throw new UserNotFoundException(userId);
        }
        return todoRepository.findByUserId(userId);
    }

    public Todo getTodoById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    public Todo createTodo(Todo todo) {
        // 사용자 검증
        if (todo.getUser() == null || !userService.existsById(todo.getUser().getId())) {
            throw new UserNotFoundException(todo.getUser().getId());
        }
        return todoRepository.save(todo);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        Todo todo = getTodoById(id);

        if (updatedTodo.getUser() != null && !userService.existsById(updatedTodo.getUser().getId())) {
            throw new UserNotFoundException(updatedTodo.getUser().getId());
        }

        todo.setTitle(updatedTodo.getTitle());
        todo.setDescription(updatedTodo.getDescription());
        todo.setCompleted(updatedTodo.isCompleted());
        todo.setPriority(updatedTodo.getPriority());
        todo.setDueDate(updatedTodo.getDueDate());
        todo.setUser(updatedTodo.getUser());

        return todoRepository.save(todo);
    }

    public void deleteTodo(Long id) {
        if (!todoRepository.existsById(id)) {
            throw new TodoNotFoundException(id);
        }
        todoRepository.deleteById(id);
    }

    public List<Todo> searchByKeyword(String keyword) {
        return todoRepository.searchByKeyword(keyword);
    }
}
