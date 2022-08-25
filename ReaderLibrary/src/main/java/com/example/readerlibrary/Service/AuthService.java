package com.example.readerlibrary.Service;

import com.example.readerlibrary.Model.User;
import com.example.readerlibrary.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;

    public List<User> getUsers() {
        return authRepository.findAll();
    }

    public void addUser(User user) {
        authRepository.save(user);
    }

    public void updateUser(User user, Integer id) {
        User oldUser=authRepository.getById(id);
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setRole(user.getRole());
        authRepository.save(oldUser);
    }
    public void deleteUser(Integer id) {
        User myUser=authRepository.getById(id);
        authRepository.delete(myUser);
    }

}
