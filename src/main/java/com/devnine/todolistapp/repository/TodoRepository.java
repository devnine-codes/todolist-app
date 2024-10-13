package com.devnine.todolistapp.repository;

import com.devnine.todolistapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
