package com.devnine.todolistapp.service;

import com.devnine.todolistapp.exception.UserNotFoundException;
import com.devnine.todolistapp.model.User;
import com.devnine.todolistapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // 모든 사용자 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ID로 사용자 조회
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    // 이메일로 사용자 조회
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException(email));
    }

    // 새 사용자 생성
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // 사용자 존재 여부 확인
    public boolean existsById(Long id) {
        return userRepository.existsById(id);
    }

    // 사용자 삭제
    public void deleteUser(Long id) {
        if (!existsById(id)) {
            throw new UserNotFoundException(id);
        }
        userRepository.deleteById(id);
    }
}
