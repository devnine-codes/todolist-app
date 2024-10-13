package com.devnine.todolistapp.repository;

import com.devnine.todolistapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
