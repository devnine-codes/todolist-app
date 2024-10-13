package com.devnine.todolistapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed;

    // 우선순위 필드 추가 (LOW, MEDIUM, HIGH)
    @Enumerated(EnumType.STRING)
    private Priority priority;

    // 마감일 필드 추가
    private LocalDate dueDate;

    // User와의 관계 (다대일)
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }
}
