package com.devnine.todolistapp.repository;

import com.devnine.todolistapp.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    // 특정 사용자의 할 일 목록 조회
    @Query("SELECT t FROM Todo t WHERE t.user.id = :userId")
    List<Todo> findByUserId(Long userId);
}
