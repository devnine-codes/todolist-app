package com.devnine.todolistapp.repository;

import com.devnine.todolistapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // 특정 사용자의 할 일 조회
    @Query("SELECT t FROM Todo t WHERE t.user.id = :userId")
    List<Todo> findByUserId(Long userId);

    // 우선순위별 할 일 조회
    List<Todo> findByPriority(Todo.Priority priority);

    // 특정 기간 내 마감일 조회
    List<Todo> findByDueDateBetween(LocalDate startDate, LocalDate endDate);
}
