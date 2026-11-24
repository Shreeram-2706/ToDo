package dev.HelloWorld.service;

import dev.HelloWorld.models.User;
import dev.HelloWorld.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository UserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(User user) {
        return UserRepository.save(user);
    }

    public User getUserById(Long id) {
        return UserRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }
}
