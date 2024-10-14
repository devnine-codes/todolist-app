package com.devnine.todolistapp.exception;

public class UserNotFoundException extends RuntimeException {

    // ID 기반 예외 메시지
    public UserNotFoundException(Long userId) {
        super("User with ID " + userId + " not found.");
    }

    // 이메일 기반 예외 메시지
    public UserNotFoundException(String email) {
        super("User with email " + email + " not found.");
    }
}
