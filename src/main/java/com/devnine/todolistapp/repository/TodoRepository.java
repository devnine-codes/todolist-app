package com.devnine.todolistapp.repository;

import com.devnine.todolistapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // 완료된 할 일 조회 쿼리
    @Query("SELECT t FROM Todo t WHERE t.completed = true")
    List<Todo> findCompletedTodos();
}
